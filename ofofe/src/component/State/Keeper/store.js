import { applyMiddleware, combineReducers, legacy_createStore } from "redux";
import { authReducer } from "../Authentication/Reducer";
import { thunk } from "redux-thunk";

const rooteReducer = combineReducers({
  auth: authReducer,
});
export const store = legacy_createStore(rooteReducer, applyMiddleware(thunk));
