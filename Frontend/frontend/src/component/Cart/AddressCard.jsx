import React from "react";
import HomeIcon from "@mui/icons-material/Home";
import { Button, Card } from "@mui/material";

export const AddressCard = ({ item, showButton, handleSelectAddress }) => {

  return (
    <Card className="flex gap-5 w-64 p-5 ">
      <HomeIcon />
      <div className="space-y-3 text-gray-500 ">
        <h1 className="font-semibold text-lg-10 text-white ">Home</h1>
        <p>
          Mumbai, new shivam building, gokuldham market, 530068, Maharastra,
          India
        </p>
        {showButton && (
          <Button
            varient="outlined"
            fullWidth
            onClick={() => handleSelectAddress(item)}
          >
            select
          </Button>
        )}
      </div>
    </Card>
  );
};
