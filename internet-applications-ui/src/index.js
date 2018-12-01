import React from "react";
import ReactDOM from "react-dom";
import {Provider} from "react-redux";
import {ConnectedRouter} from "connected-react-router/immutable";

import "./index.scss";
import * as serviceWorker from "./serviceWorker";
import browserHistory from "./util/browserHistory";
import configureStore from "./redux/store";
import App from "./containers/App";

const store = configureStore({}, browserHistory);

ReactDOM.render(
    <Provider store={store}>
        <ConnectedRouter history={browserHistory}>
            <App/>
        </ConnectedRouter>
    </Provider>,
    document.getElementById("root")
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
