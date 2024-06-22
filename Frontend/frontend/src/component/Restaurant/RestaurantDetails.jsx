import React, { useState } from "react";
import LocationOnIcon from "@mui/icons-material/LocationOn";
import FormControl from "@mui/material/FormControl";
import RadioGroup from "@mui/material/RadioGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import Radio from "@mui/material/Radio";
import { Divider, Grid, Typography } from "@mui/material";
import CalendarTodayIcon from "@mui/icons-material/CalendarToday";
import MenuCard from "./MenuCard";

const categories = ["pizza", "biryani", "burger", "chiken", "rice"];

const foodTypes = [
  { label: "All", value: "all" },
  { label: "Vegetarian only", value: "vegetarian" },
  { label: "Non-Vegetarian", value: "non_vegetarian" },
  { label: "Seasonal", value: "seasonal" },
];

const menu=[1,1,1,1,1,1];

const RestaurantDetails = () => {
  const [foodType, setFoodType] = useState("all");
  
  const handleFilter=(e)=> {
      console.log(e.target.value, e.target.name)
  }

  return (
    <div className="px-5 lg:px-20">
      <section>
        <h3 className="text-gray-500 py-2 mt-10">
          Home/india/indian fast food/3
        </h3>
        <div>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <img
                className="w-full h-[40vh] object-cover"
                src="https://i.pinimg.com/564x/41/c8/83/41c883a2a789d0dbd10179b2e55b333e.jpg"
                alt=""
              />
            </Grid>
            <Grid item xs={12} lg={6}>
              <img
                className="w-full h-[40vh] object-cover"
                src="https://i.pinimg.com/236x/7d/0e/1d/7d0e1dad4ca370867484d0efb456f354.jpg"
                alt=""
              />
            </Grid>
            <Grid item xs={12} lg={6}>
              <img
                className="w-full h-[40vh] object-cover"
                src="https://i.pinimg.com/236x/45/80/1a/45801a1d80328bccd13c6f4dad0d3635.jpg"
                alt=""
              />
            </Grid>
          </Grid>
        </div>
        <div className="pt-3 pb-5 ">
          <h1 className="text-4xl font-semibold ">Indian Fast Food</h1>
          <p className="text-gray-500 mt-1">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Enim vero
            minus perspiciatis quas ut aliquid voluptatem quasi molestias
            facilis iure dicta, fuga, dolorem quos eveniet impedit quo? Alias,
            labore impedit.
          </p>
          <div className="space-y-3 mt-3">
            <p className="text-gray-500 flex item-center gap-3">
              <LocationOnIcon />
              <span>Mumbai, Maharastra</span>
            </p>

            <p className="text-gray-500 flex item-center gap-3">
              <CalendarTodayIcon />
              <span>Mon-Sun: 9:00 AM - 9:00 PM (Today)</span>
            </p>
          </div>
        </div>
      </section>
      <Divider />
      <section className="pt-[2rem] lg:flex relative">
        <div className="space-y-10 lg:w-[20%] filter ">
          <div className="box space-y-5 lg:sticky top-28 ">
            <div>
              <Typography varient="h5" sx={{ paddingBottom: "1rem" }}>
                Food Type
              </Typography>

              <FormControl className="py-10 space-y-5" component={"fieldset"}>
                <RadioGroup onChange={handleFilter} name="food_type" value={foodType}>
                  {foodTypes.map((item) => (
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
            <Divider/>
            <div>
              <Typography variant="h5" sx={{ paddingBottom: "1rem" }}>
                Food Category
              </Typography>

              <FormControl className="py-10 space-y-5" component={"fieldset"}>
                <RadioGroup onChange={handleFilter} name="food_type" value={categories}>
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
        
        <div className="space-y-5 lg:w-[80%] lg:pl-10">
          {menu.map((item)=><MenuCard/>)}
          </div>
      </section>
    </div>
  );
};

export default RestaurantDetails;
