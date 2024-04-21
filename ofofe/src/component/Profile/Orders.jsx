import React, { useEffect } from "react";
import OrderCard from "./OrderCard";
import { useSelector, useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { getUsersOrders } from "../State/Order/Action";

const Orders = () => {
  const { cart, auth, order } = useSelector((store) => store);
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const jwt = localStorage.getItem("jwt");

  useEffect(() => {
    dispatch(getUsersOrders(jwt));
  }, [auth.jwt]);

  return (
    <div className="flex items-center flex-col">
      <h1 className="text-xl text-center py-7 font-semibold">My Order</h1>
      <div className="space-y-5 w-full lg:w-1/2">
        {order.orders.map((order) =>
          order.items.map((item) => <OrderCard order={order} item={item} />)
        )}
      </div>
    </div>
  );
};

export default Orders;
