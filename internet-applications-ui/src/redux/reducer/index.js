import {combineReducers} from "redux-immutable";
import {connectRouter} from "connected-react-router/immutable";

import entityReducer from "./entities/index";

function configureReducer(browserHistory, injectedReducers = {}) {
    return combineReducers({
        router: connectRouter(browserHistory),
        entities: entityReducer,
        ...injectedReducers
    });
}

export default configureReducer;
