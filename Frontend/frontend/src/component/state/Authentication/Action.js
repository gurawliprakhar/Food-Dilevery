export const registerUser=(reqData)=>async(dispatch)=>{
    dispatch({type:REGISTER_REQUEST})
   try {
     const {data} = await axios.post(` `)
   } catch (error) {
      console.log("error", error)
   }
}
