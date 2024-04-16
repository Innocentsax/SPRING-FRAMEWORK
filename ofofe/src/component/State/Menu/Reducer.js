import * as actionTypes from "./ActionTypes";

const initialState = {
  menuItems: [],
  loading: false,
  error: null,
  search: [],
  message: null,
};

const menuItemsReducer = (state = initialState, action) => {
  switch (action.type) {
    case actionTypes.CREATE_MENU_ITEM_REQUEST:
    case actionTypes.GET_MENU_ITEMS_BY_RESTAURANT_ID_REQUEST:
    case actionTypes.DELETE_MENU_ITEM_REQUEST:
    case actionTypes.SEARCH_MENU_ITEM_REQUEST:
    case actionTypes.UPDATE_MENU_ITEMS_AVAILABILITY_REQUEST:
      return {
        ...state,
        loading: true,
        error: null,
        message: null,
      };
    case actionTypes.CREATE_MENU_ITEM_SUCCESS:
      return {
        ...state,
        loading: false,
        menuItems: [...state.menuItems, action.payload],
        message: "You have successfully created",
      };
    case actionTypes.DELETE_MENU_ITEM_SUCCESS:
      return {
        ...state,
        loading: false,
        menuItems: state.menuItems.filter(
          (menuItem) => menuItem.id !== action.payload
        ),
        message: "You have successfully deleted",
      };
    case actionTypes.GET_MENU_ITEMS_BY_RESTAURANT_ID_SUCCESS:
      return {
        ...state,
        loading: false,
        menuItems: action.payload,
      };
    case actionTypes.SEARCH_MENU_ITEM_SUCCESS:
      return {
        ...state,
        loading: false,
        search: action.payload,
      };
    case actionTypes.UPDATE_MENU_ITEMS_AVAILABILITY_SUCCESS:
      console.log("updated items id ", action.payload.id);
      return {
        ...state,
        loading: false,
        menuItems: state.menuItems.map((menuItem) =>
          menuItem.id === action.payload.id ? action.payload : menuItem
        ),
        message: "You have successfully updated",
      };

    case actionTypes.CREATE_MENU_ITEM_FAILURE:
    case actionTypes.GET_MENU_ITEMS_BY_RESTAURANT_ID_FAILURE:
    case actionTypes.DELETE_MENU_ITEM_FAILURE:
    case actionTypes.SEARCH_MENU_ITEM_FAILURE:
    case actionTypes.UPDATE_MENU_ITEMS_AVAILABILITY_FAILURE:
      return {
        ...state,
        loading: false,
        error: action.payload,
        message: null,
      };

    default:
      return state;
  }
};
export default menuItemsReducer;
