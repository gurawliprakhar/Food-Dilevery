import React from 'react';
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Slider from 'react-slick';
import CarouselItem from './CarouselItem'; // Adjust path as necessary
import topMeel from './topMeel'; // Adjust path as necessary

const MultiItemCarousel = () => {
 
  return (
    <div>
      <Slider>
        {topMeel.map((item, index) => (
          <CarouselItem 
            key={index}
            image={item.image}  
            title={item.title} 
          />
        ))}
      </Slider>
    </div>
  );
}

export default MultiItemCarousel;
