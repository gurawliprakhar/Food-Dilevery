const initialState={
  user:null,
  isLoading:false,
  error:null
  jwt: null, 
  favorites:[],
  success:null
}

const authReducer=(state=initialState,action)=>{
    switch (action.type) {
        case REGISTER_REQUEST:
        case LOGIN_REQUEST:
        case GET_USER_DATA:
        case ADD_TO_FAVORITE_REQUEST:
        return {...state,isLoading:true,error:null,}
    
        case REGISTER_SUCCESS:
        case LOGIN_SUCCESS:
            return {
                ...state, 
                isLoading:false,
                jwt:action.payload,
                success:"Register Success",
            };
        case ADD_TO_FAVORITE_SUCCESS:
            return {
                ...state,
                isLoading:false,
                error:null,
                favorites:is
                 
            }
        default:
            break;
    }
}