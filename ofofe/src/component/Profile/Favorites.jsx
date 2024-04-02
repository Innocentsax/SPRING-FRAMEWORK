import React from "react";
import RestaurantCard from "../Restaurant/RestaurantCard";

const favorites = () => {
  return (
    <div>
      <h1 className="py-5 text-xl font-semibold text-center">My Favorites</h1>
      <div className="flex flex-wrap gap-3 justify-center">
        {[1, 1, 1].map((item) => (
          <RestaurantCard />
        ))}
      </div>
    </div>
  );
};

export default favorites;
