import axios from "axios";
import {
  ADD_TO_FAVORITE_REQUEST,
  ADD_TO_FAVORITE_SUCCESS,
  GET_USER_REQUEST,
  GET_USER_SUCCESS,
  LOGIN_REQUEST,
  LOGIN_SUCCESS,
  LOGOUT,
  REGISTER_REQUEST,
} from "./ActionType";
import { API_URL, api } from "../../Config/api";

export const registerUser = (reqData) => async (dispatch) => {
  dispatch({ type: REGISTER_REQUEST });
  try {
    const { data } = await axios.post(
      `${API_URL}/auth/signup`,
      reqData.userData
    );
    if (data.jwt) localStorage.setItem("jwt", data.jwt);
    if (data.role === "ROLE_RESTAURANT_OWNER") {
      reqData.navigate("/admin/restaurant");
    } else {
      reqData.navigate("/");
    }
    dispatch({ type: REGISTER_SUCCESS, payload: data.jwt });
    console.log("Register success ", data);
  } catch (error) {
    console.log("error", error);
  }
};

export const loginUser = (reqData) => async (dispatch) => {
  dispatch({ type: LOGIN_REQUEST });
  try {
    const { data } = await axios.post(
      `${API_URL}/auth/signin`,
      reqData.userData
    );
    if (data.jwt) localStorage.setItem("jwt", data.jwt);
    if (data.role === "ROLE_RESTAURANT_OWNER") {
      reqData.navigate("/admin/restaurant");
    } else {
      reqData.navigate("/");
    }
    dispatch({ type: LOGIN_SUCCESS, payload: data.jwt });
    console.log("Login success ", data);
  } catch (error) {
    console.log("error", error);
  }
};

export const getUser = (jwt) => async (dispatch) => {
  dispatch({ type: GET_USER_REQUEST });
  try {
    const { data } = await api.get(`${API_URL}/api/users/profile`, {
      Headers: { Authorization: `Bearer ${jwt}` },
    });
    dispatch({ type: GET_USER_SUCCESS, payload: data });
    console.log("user profile ", data);
  } catch (error) {
    console.log("error", error);
  }
};

export const addToFavorite =
  ({ jwt, restaurantId }) =>
  async (dispatch) => {
    dispatch({ type: ADD_TO_FAVORITE_REQUEST });
    try {
      const { data } = await api.put(
        `${API_URL}api/restaurant/${restaurantId}/add-favorites`,
        {},
        {
          Headers: { Authorization: `Bearer ${jwt}` },
        }
      );
      dispatch({ type: ADD_TO_FAVORITE_SUCCESS, payload: data });
      console.log("Add to favorite ", data);
    } catch (error) {
      console.log("error", error);
    }
  };

export const logout = () => async (dispatch) => {
  dispatch({ type: LOGOUT });
  try {
    dispatch({ type: LOGIN_SUCCESS });
    console.log("Logout Success ", data);
  } catch (error) {
    console.log("error", error);
  }
};
