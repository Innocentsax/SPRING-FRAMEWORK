import { Button, Card } from "@mui/material";
import React from "react";

const OrderCard = () => {
  return (
    <Card className="flex justify-between items-center p-5">
      <div className="flex items-center space-x-5">
        <img
          className="h-16 w-16"
          src="https://cdn.pixabay.com/photo/2018/07/10/21/23/pancake-3529653_1280.jpg"
          alt=""
        />
        <div>
          <p>Pancake</p>
          <p>₦2000</p>
        </div>
      </div>
      <div>
        <Button className="cursor-not-allow">Completed</Button>
      </div>
    </Card>
  );
};

export default OrderCard;
