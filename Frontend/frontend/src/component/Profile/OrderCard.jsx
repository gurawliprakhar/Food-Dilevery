import React from "react";
import { Card, Button } from "@mui/material";

export const OrderCard = () => {
  return (
    <Card className="flex justify-between items-center p-5">
      <div className="flex items-center space-x-5 ">
        <img
          className="h-16 w-16 "
          src="https://media.istockphoto.com/id/1345624336/photo/chicken-biriyani.jpg?s=612x612&w=0&k=20&c=adU_N0P-1SKMQLZu5yu7aPknfLLgbViI8XILqLP92A4="
          alt=""
        />
        <div>
          <p>Biryani</p>
          <p>₹399</p>
        </div>
      </div>
      <div>
        <Button className="cursor-not-allowed">
          completed
        </Button>
      </div>
    </Card>
  );
};
