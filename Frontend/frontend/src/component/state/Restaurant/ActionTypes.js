import { api } from "../../../config/api";
import {
    GET_ALL_RESTAURANT_REQUEST,
    GET_ALL_RESTAURANT_SUCCESS,
    GET_ALL_RESTAURANT_FAILURE,
    GET_RESTAURANT_BY_ID_REQUEST,
    GET_RESTAURANT_BY_ID_SUCCESS,
    GET_RESTAURANT_BY_ID_FAILURE,
    GET_RESTAURANT_BY_USER_ID_SUCCESS
} from "./ActionTypes";
import { CREATE_RESTAURANT_FAILURE, CREATE_RESTAURANT_REQUEST, CREATE_RESTAURANT_SUCCESS, GET_RESTAURANT_BY_USER_ID_FAILURE, GET_RESTAURANT_BY_USER_ID_REQUEST, UPDATE_RESTAURANT_STATUS_FAILURE, UPDATE_RESTAURANT_STATUS_REQUEST, UPDATE_RESTAURANT_STATUS_SUCESS } from "./Reducer";

export const getAllRestaurantsAction = (token) => {
    return async (dispatch) => {
        dispatch({ type: GET_ALL_RESTAURANT_REQUEST });
        try {
            const { data } = await api.get("/api/restaurants", {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });
            dispatch({ type: GET_ALL_RESTAURANT_SUCCESS, payload: data });
            console.log("All restaurants", data);
        } catch (error) {
            console.log("Catch error", error);
            dispatch({ type: GET_ALL_RESTAURANT_FAILURE, payload: error });
        }
    };
};

export const getRestaurantById = (reqData) => {
    return async (dispatch) => {
        dispatch({ type: GET_RESTAURANT_BY_ID_REQUEST });
        try {
            const response = await api.get(`/api/restaurants/${reqData.restaurantId}`, {
                headers: {
                    Authorization: `Bearer ${reqData.jwt}`,
                },
            });
            dispatch({ type: GET_RESTAURANT_BY_ID_SUCCESS, payload: response.data });
        } catch (error) {
            console.log("Error", error);
            dispatch({ type: GET_RESTAURANT_BY_ID_FAILURE, payload: error });
        }
    };
};

export const getRestaurantByUserId = (jwt) => {
    return async (dispatch) => {
        dispatch ({ type: GET_RESTAURANT_BY_USER_ID_REQUEST});
        try {
            const { data } = await api.get(`/api/admin/restaurants/user`,{
                headers: {
                    Authorization: `Bearer ${jwt}` ,
                },
            });
            console.log("get restaurant by user id", data);
            dispatch({type:GET_RESTAURANT_BY_USER_ID_SUCCESS, payload: data})
        } catch (error) {
            console.log("catch error ", error);
            dispatch({
                type: GET_RESTAURANT_BY_USER_ID_FAILURE,
                payload: error.message,
            })
        }
    }
}


export const createRestaurant = (reqData) => {
   console.log("token--------", reqData.token);
   return async (dispatch) => {
    dispatch({type:CREATE_RESTAURANT_REQUEST});
    try {
      const { data } = await api.post(`/api/admin/restaurants`, reqData.data, {
        headers: {
            Authorization: `Bearer $(reqData.token)`,
        },
      });
      dispatch({type:CREATE_RESTAURANT_SUCCESS, payload:data});
      console.log("created restaaurant ", data)
    } catch(error) {
       console.log("catch error ", error );
       dispatch({type:CREATE_RESTAURANT_FAILURE, payload:error})
    }
   }
}

export const updateRestaurant = ({restaurantId, restaurantData, jwt}) => {
    return async (dispatch) => {
        dispatch({type:UPDATE_RESTAURANT_STATUS_REQUEST})
        try {
            const res = await api.put(
                `api/admin/restaurant/${restaurantId}`,
                restaurantData,
                {
                    headers: {
                    Authorization: `Bearer ${jwt}`,
                    },
                }
            );
        dispatch({type: UPDATE_RESTAURANT_STATUS_SUCESS})
        } catch (error) {
            dispatch({type:UPDATE_RESTAURANT_STATUS_FAILURE, payload:error})
        }
    };
};