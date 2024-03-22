import {
  Divider,
  FormControl,
  FormControlLabel,
  Grid,
  Radio,
  RadioGroup,
  Typography,
} from "@mui/material";
import React from "react";
import LocationOnIcon from "@mui/icons-material/LocationOn";
import CalendarTodayIcon from "@mui/icons-material/CalendarToday";
import MenuCard from "./MenuCard";

const categories = ["Pizza", "Burger", "French Fries", "Pasta", "Salad"];
const FoodTypes = [
  { label: "All", value: "All" },
  { label: "Vegetarian only", value: "Vegetarians" },
  { label: "Non-vegetarian", value: "non-vegetarian" },
  { label: "Seasonal", value: "seasonal" },
];
const menu = [1, 1, 1, 1, 1, 1];
const RestaurantDetails = () => {
  const [foodType, setFoodType] = React.useState("All");
  const handleFilter = (e) => {
    console.log(e.target.value, e.target.name);
  };
  return (
    <div className="px-5 lg:px-20">
      <section>
        <h3 className="text-gray-500 py-2 mt-10">Home/Efik/TransCorp Hotel</h3>
        <div>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <img
                className="w-full h-[40vh] object-cover"
                src="https://images.pexels.com/photos/460537/pexels-photo-460537.jpeg?auto=compress&cs=tinysrgb&w=800"
              />
            </Grid>
            <Grid item xs={12} lg={6}>
              <img
                className="w-full h-[40vh] object-cover"
                src="https://images.pexels.com/photos/1307698/pexels-photo-1307698.jpeg?auto=compress&cs=tinysrgb&w=800"
              />
            </Grid>
            <Grid item xs={12} lg={6}>
              <img
                className="w-full h-[40vh] object-cover"
                src="https://images.pexels.com/photos/2696064/pexels-photo-2696064.jpeg?auto=compress&cs=tinysrgb&w=800"
              />
            </Grid>
          </Grid>
        </div>
        <div className="pt-3 pb-5">
          <h1 className="text-4xl font-semibold">TransCorp Hotel</h1>
          <p className="text-gray-500 mt-1">
            The Transcorp Hotel Calabar is a luxurious hotel located in Oguwo
            Street, Box Hill, Calabar in Nigeria's Cross River State. It offers
            comfortable and elegant accommodations, fine dining options, and
            recreational facilities such as a fitness center, swimming pool, and
            a rooftop bar.
          </p>
          <div className="space-y-3 mt-3">
            <p className="text-gray-500 flex items-center gap-3">
              <LocationOnIcon />
              <span>Stadium Road, Calabar.</span>
            </p>
            <p className="text-gray-500 flex items-center gap-3">
              <CalendarTodayIcon />
              <span>Mon-Sun: 9:00 AM - 9:00 PM (Today)</span>
            </p>
          </div>
        </div>
      </section>
      <Divider />
      <section className="pt-[2rem] lg:flex relative">
        <div className="space-y-10 lg:w-[20%] filter ">
          <div className="box space-y-5 lg:sticky top-28">
            <div>
              <Typography variant="5" sx={{ paddingBottom: "1rem" }}>
                Food Type
              </Typography>
              <div className="py-3 space-y-5" component={"fieldset"}>
                <FormControl>
                  <RadioGroup
                    onChange={handleFilter}
                    name="food_type"
                    value={foodType}
                  >
                    {FoodTypes.map((item) => (
                      <FormControlLabel
                        key={item.value}
                        value={item.value}
                        control={<Radio />}
                        label={item.label}
                      />
                    ))}
                  </RadioGroup>
                </FormControl>
              </div>
            </div>
            <Divider />
            <div>
              <Typography variant="5" sx={{ paddingBottom: "1rem" }}>
                Food Category
              </Typography>
              <div className="py-3 space-y-5">
                <FormControl component={"fieldset"}>
                  <RadioGroup
                    onChange={handleFilter}
                    name="food_type"
                    value={foodType}
                  >
                    {categories.map((item) => (
                      <FormControlLabel
                        key={item}
                        value={item}
                        control={<Radio />}
                        label={item}
                      />
                    ))}
                  </RadioGroup>
                </FormControl>
              </div>
            </div>
          </div>
        </div>
        <div className="space-y-5 lg:w-[80%] lg:pl-10">
          {menu.map((item) => (
            <MenuCard />
          ))}
        </div>
      </section>
    </div>
  );
};

export default RestaurantDetails;
