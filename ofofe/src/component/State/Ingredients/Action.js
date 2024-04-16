import { api } from "../../Config/api";
import {
  CREATE_INGREDIENTS_CATEGORY_FAILURE,
  CREATE_INGREDIENTS_CATEGORY_REQUEST,
  CREATE_INGREDIENTS_CATEGORY_SUCCESS,
  CREATE_INGREDIENTS_FAILURE,
  CREATE_INGREDIENTS_REQUEST,
  CREATE_INGREDIENTS_SUCCESS,
  GET_INGREDIENTS,
  GET_INGREDIENTS_CATEGORY_FAILURE,
  GET_INGREDIENTS_CATEGORY_REQUEST,
  GET_INGREDIENTS_CATEGORY_SUCCESS,
  UPDATE_STOCK,
} from "./ActionTypes";

export const getIngredientsOfRestaurant = ({ id, jwt }) => {
  return async (dispatch) => {
    try {
      const response = await api.get(
        `/api/admin/ingredients/restaurants/${id}`,
        {
          headers: {
            Authorization: `Bearer ${jwt}`,
          },
        }
      );
      console.log("get ingredients of restaurant ", response.data);
      dispatch({ type: GET_INGREDIENTS, payload: response.data });
    } catch (error) {
      console.log("error", error);
      dispatch({ type: GET_INGREDIENTS_OF_RESTAURANT_FAILURE, payload: error });
    }
  };
};

export const createIngredient = ({ data, jwt }) => {
  return async (dispatch) => {
    dispatch({ type: CREATE_INGREDIENTS_REQUEST });
    try {
      const response = await api.post("/api/admin/ingredients", data, {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });
      console.log("create ingredient ", response.data);
      dispatch({ type: CREATE_INGREDIENTS_SUCCESS, payload: response.data });
    } catch (error) {
      console.log("error", error);
      dispatch({ type: CREATE_INGREDIENTS_FAILURE, payload: error });
    }
  };
};

export const createIngredientCategory = ({ data, jwt }) => {
  console.log("data", data, "jwt", jwt);
  return async (dispatch) => {
    dispatch({ type: CREATE_INGREDIENTS_CATEGORY_REQUEST });
    try {
      const response = await api.post("/api/admin/ingredients/category", data, {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });
      console.log("create ingredient category ", response.data);
      dispatch({
        type: CREATE_INGREDIENTS_CATEGORY_SUCCESS,
        payload: response.data,
      });
    } catch (error) {
      console.log("error", error);
      dispatch({ type: CREATE_INGREDIENTS_CATEGORY_FAILURE, payload: error });
    }
  };
};

export const getIngredientCategory = ({ id, jwt }) => {
  return async (dispatch) => {
    dispatch({ type: GET_INGREDIENTS_CATEGORY_REQUEST });
    try {
      const response = await api.get(
        `/api/admin/ingredients/category/${id}/category`,
        {
          headers: {
            Authorization: `Bearer ${jwt}`,
          },
        }
      );
      console.log("get ingredient category ", response.data);
      dispatch({
        type: GET_INGREDIENTS_CATEGORY_SUCCESS,
        payload: response.data,
      });
    } catch (error) {
      console.log("error", error);
      dispatch({ type: GET_INGREDIENTS_CATEGORY_FAILURE, payload: error });
    }
  };
};

export const updateStockOfIngredient = ({ id, jwt }) => {
  return async (dispatch) => {
    try {
      const { data } = await api.put(
        `/api/admin/ingredients/${id}/stock`,
        {},
        {
          headers: {
            Authorization: `Bearer ${jwt}`,
          },
        }
      );
      console.log("update stock of ingredient ", data);
      dispatch({ type: UPDATE_STOCK, payload: data });
    } catch (error) {
      console.log("error", error);
    }
  };
};
