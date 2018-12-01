import {applyMiddleware, compose, createStore} from "redux";
import {routerMiddleware} from "connected-react-router/immutable";
import {fromJS} from "immutable";
import createSagaMiddleware from "redux-saga";

import configureReducer from "../reducer/index";

const sagaMiddleware = createSagaMiddleware();

function configureStore(initialState = {}, browserHistory) {
    /*
    * Create the store with two middlewares
    * 1. Saga middleware makes "redux-saga" work
    * 2. Router middleware syncs the location/URL path to the state
    */
    const middlewares = [sagaMiddleware, routerMiddleware(browserHistory)];

    const enhancers = [applyMiddleware(...middlewares)];

    // If Redux DevTools Extension is installed use it, otherwise use Redux compose
    const composeEnhancers =
        process.env.NODE_ENV !== "production" && typeof window === "object" && window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__
        ? window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__({})
        : compose;

    const store = createStore(
        configureReducer(browserHistory),
        fromJS(initialState),
        composeEnhancers(...enhancers)
    );

    // Extensions
    store.runSaga = sagaMiddleware.run;
    store.injectedReducers = {}; // Reducer registry
    store.injectedSagas = {}; // Saga registry

    // Make reducers hot reloadable
    if (module.hot) {
        module.hot.accept("../reducer/index", () => {
            const reloadedReducer = configureReducer(browserHistory, store.injectedReducers);
            store.replaceReducer(reloadedReducer);
        });
    }

    return store;
}

export default configureStore;
