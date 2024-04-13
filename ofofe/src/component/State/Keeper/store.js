import { applyMiddleware, combineReducers, legacy_createStore } from "redux";
import { authReducer } from "../Authentication/Reducer";
import { thunk } from "redux-thunk";
import menuItemsReducer from "../Menu/Reducer";

const rooteReducer = combineReducers({
  auth: authReducer,
  restaurant: restaurantReducer,
  menu: menuItemsReducer,
});
export const store = legacy_createStore(rooteReducer, applyMiddleware(thunk));
