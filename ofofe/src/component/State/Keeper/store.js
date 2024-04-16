import { applyMiddleware, combineReducers, legacy_createStore } from "redux";
import { authReducer } from "../Authentication/Reducer";
import { thunk } from "redux-thunk";
import menuItemsReducer from "../Menu/Reducer";
import cartReducer from "../Cart/Reducer";
import { orderReducer } from "../Order/Reducer";
import restaurantReducer from "../Restaurant/Reducer";
import restaurantsOrderReducer from "../Restaurant Oder/Reducer";
import { ingredientReducer } from "../Ingredients/Reducer";

const rooteReducer = combineReducers({
  auth: authReducer,
  restaurant: restaurantReducer,
  menu: menuItemsReducer,
  cart: cartReducer,
  order: orderReducer,
  restaurantOrder: restaurantsOrderReducer,
  ingredients: ingredientReducer,
});
export const store = legacy_createStore(rooteReducer, applyMiddleware(thunk));
