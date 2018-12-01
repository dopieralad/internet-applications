import {fromJS} from "immutable";

const initialState = fromJS({
    byId: {}
});

function reduce(state = initialState) {
    return state;
}

export default reduce;
