import {combineReducers} from "redux-immutable";

import userReducer from "./users";

function configureReducer() {
    return combineReducers({
        users: userReducer
    });
}

export default configureReducer;
