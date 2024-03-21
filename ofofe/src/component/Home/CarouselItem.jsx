import React from "react";

const CarouselItem = ({ image, title }) => {
  return (
    <div className="flex flex-col justify-center items-center">
      <img
        className="w-[10rem] h-[10rem] lg:h-[14rem] lg:w-[14rem] rounded-full object-cover object-center"
        src={image}
        alt=""
      />
      <span className="py-5 font-semibold text-xl text-grey-400">{title}</span>
    </div>
  );
};

export default CarouselItem;
