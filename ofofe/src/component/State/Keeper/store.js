import { applyMiddleware, combineReducers, legacy_createStore } from "redux";
import { authReducer } from "../Authentication/Reducer";
import { thunk } from "redux-thunk";
import menuItemsReducer from "../Menu/Reducer";
import cartReducer from "../Cart/Reducer";

const rooteReducer = combineReducers({
  auth: authReducer,
  restaurant: restaurantReducer,
  menu: menuItemsReducer,
  cart: cartReducer,
});
export const store = legacy_createStore(rooteReducer, applyMiddleware(thunk));
