import React from "react";
import ReactDOM from "react-dom";
import {Router} from "react-router-dom";

import "./index.scss";
import * as serviceWorker from "./serviceWorker";
import browserHistory from "./util/browserHistory";
import App from "./containers/App";


ReactDOM.render(
    <Router history={browserHistory}>
        <App/>
    </Router>,
    document.getElementById("root")
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
