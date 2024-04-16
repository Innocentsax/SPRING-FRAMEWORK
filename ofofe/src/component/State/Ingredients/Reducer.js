import {
  CREATE_INGREDIENTS_CATEGORY_SUCCESS,
  CREATE_INGREDIENTS_SUCCESS,
  GET_INGREDIENTS,
  GET_INGREDIENTS_CATEGORY_SUCCESS,
  UPDATE_STOCK,
} from "./ActionTypes";

const initialState = {
  ingredients: [],
  update: null,
  category: [],
};

export const ingredientReducer = (state = initialState, action) => {
  switch (action.type) {
    case GET_INGREDIENTS:
      return {
        ...state,
        ingredients: action.payload,
      };
    case GET_INGREDIENTS_CATEGORY_SUCCESS:
      return {
        ...state,
        ingredients: action.payload,
      };
    case CREATE_INGREDIENTS_CATEGORY_SUCCESS:
      return {
        ...state,
        ingredients: [...state.category, action.payload],
      };
    case CREATE_INGREDIENTS_SUCCESS:
      return {
        ...state,
        ingredients: [...state.ingredients, action.payload],
      };
    case UPDATE_STOCK:
      return {
        ...state,
        update: action.payload,
        ingredients: state.ingredients.map((item) =>
          item.id === action.payload.id ? action.payload : item
        ),
      };
    default:
      return state;
  }
};
