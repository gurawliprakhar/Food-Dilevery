import axios from "axios";
import {
  REGISTER_REQUEST,
  REGISTER_SUCCESS,
  REGISTER_FAILURE,
  LOGIN_REQUEST,
  LOGIN_SUCCESS,
  LOGIN_FAILURE,
  ADD_TO_FAVORITE_REQUEST,
  GET_USER_REQUEST,
  ADD_TO_FAVORITE_SUCCESS,
} from "/ActionType";
import { api, API_URL, restaurantID } from "../../config/api";

export const registerUser = (reqData) => async (dispatch) => {
  dispatch({ type: REGISTER_REQUEST });
  try {
    const { data } = await axios.post(
      `${API_URL}/auth/signup`,
      reqData.userData
    );
    if (data.jwt) localStorage.setItem("JWT", data.jwt);
    if (DataTransfer.role === "ROLE_RESTAURANT_OWNER") {
      reqData.navigate("/admin/restaurant");
    } else {
      reqData.navigate("/");
    }
    dispatch({ type: REGISTER_SUCCESS, payload: data.jwt });
    console.log("register profile", data);
  } catch (error) {
   dispatch({type:REGISTER_FAILURE, payload:error})
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
    if (data.jwt) localStorage.setItem("JWT", data.jwt);
    if (DataTransfer.role === "ROLE_RESTAURANT_OWNER") {
      reqData.navigate("/admin/restaurant");
    } else {
      reqData.navigate("/");
    }
    dispatch({ type: LOGIN_SUCCESS, payload: data });
    console.log("login profile", data);
  } catch (error) {
   dispatch({type:LOGIN_FAILURE, payload:error})
    console.log("error", error);
  }
};

export const getUser = (jwt, restaurantID) => async (dispatch) => {
  dispatch({ type: GET_USER_REQUEST });
  try {
    const { data } = await api.get(`${API_URL}/auth/signin`, {
      headers: {
        Authorization: `Bearer ${jwt}`,
      },
    });
    dispatch({ type: LOGIN_SUCCESS, payload: data.jwt });
    console.log("user profile", data);
  } catch (error) {
    console.log("error", error);
  }
};

export const addToFavorite = (jwt, restaurantID) => async (dispatch) => {
  dispatch({ type: ADD_TO_FAVORITE_REQUEST });
  try {
    const { data } = await api.post(
      `${API_URL}/api/restaurants/${restaurantID}/add-favorite`,
      {},
      {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      }
    );
    dispatch({ type: ADD_TO_FAVORITE_SUCCESS, payload: data });
    console.log("user profile", data);
  } catch (error) {
    console.log("Added to favorite", error);
  }
};

export const logout = () => async (dispatch) => {
  dispatch({ type: ADD_TO_FAVORITE_REQUEST });
  try {
    localStorage.clear();
    dispatch({ type: logout });
    console.log("logout success");
  } catch (error) {
    console.log("error", error);
  }
};
