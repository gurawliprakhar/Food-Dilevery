import React from "react";
import {Card, Chip, IconButton} from '@mui/material';
import FavoriteIcon from '@mui/icons-material/Favorite';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';

const RestaurantCard = () => {
  return (
    <card className="w-[18rem] ">
      <div
        className={`${true ? "cursor-pointer" : "cursor-not-allowed"}relative`}
      >
        <img
          className="w-full h-[10rem] round-t-md object-cover"
          src="https://encrypted-tbn0.gstatic.com/
          images?q=tbn:ANd9GcTNgSmDxTV-EmbVxdnXOW0epWh_uFv5oETMzA&s"
        />
        <chip
          size="small"
          className="absolute top-2 left-2"
          color={true ? "succcess" : "error"}
          label={true ? "open" : "closed"}
        />
      </div>
      <div className="p-4 textPart lg:flex w-full justify-between ">
        <div className="space-y-1">
            <p className="font-semibold text-lg">
                Indian Fast Food
            </p>
           <p className="text-gray-50 text-sm">
              Craving it all? Dive into our global fla...
           </p>
        </div>
         <div>
            <IconButton>
                {true ? <FavoriteIcon/> : <FavoriteBorderIcon/>}
            </IconButton>
         </div>
      </div>
    </card>
  );
};

export default RestaurantCard;
