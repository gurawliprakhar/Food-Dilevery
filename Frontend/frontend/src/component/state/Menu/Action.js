import { api } from "../../config/api";
import { CREATE_MENU_ITEM_FAILURE,
     CREATE_MENU_ITEM_REQUEST, 
     CREATE_MENU_ITEM_SUCCESS,
     GET_MENU_ITEM_BY_RESTAURANT_ID_FAILURE, 
     GET_MENU_ITEM_BY_RESTAURANT_ID_REQUEST,
     GET_MENU_ITEM_BY_RESTAURANT_ID_SUCCESS} 
      from "./ActionType";

export const createMenuItem = ({menu,jwt}) => {
    return async (dispatch) => {
        dispatch({type: CREATE_MENU_ITEM_REQUEST});
        try {
            const { data } = await api.post("api/admin/food", menu,
                {
                    headers: {
                        Authorization: `Bearer ${jwt}`,
                    }
                }
            )
            console.log("created menu ", data)
            dispatch({type:CREATE_MENU_ITEM_SUCCESS, payload:data});
        } catch (error) {
            console.log("catch error ", error)
            dispatch({type:CREATE_MENU_ITEM_FAILURE, payload:error});
        }
    }
}

export const getMenuItemByRestaurantId = (reqData) => {
    return async (dispatch) => {
        dispatch({type:GET_MENU_ITEM_BY_RESTAURANT_ID_REQUEST})
        try {
            const { data } = await api.get(
                `api/food/restaurant/${reqData.restaurantId}?
                vegetarian=${reqData.vegetarian}
                &nonVeg=${reqData.nonVeg}
                &seasonal=${reqData.seasonal}
                &food_category=${reqData.food_category}`,
                {
                  headers: {
                    Authorization: `Bearer ${reqData.jwt}`
                   },
                }
            )
            console.log(" menu item by restaurant ", data)
            dispatch({type:GET_MENU_ITEM_BY_RESTAURANT_ID_SUCCESS})
        } catch (error) {
            dispatch({type:GET_MENU_ITEM_BY_RESTAURANT_ID_FAILURE, payload:error})
        }
    }
}

//6:27:55