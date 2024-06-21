import React from 'react';
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Slider from 'react-slick';
import CarouselItem from './CarouselItem';
import topMeel from './topMeel';

const MultiItemCarousel = () => {
  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 5,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 2000,
    arrows: false,

  };

  console.log('topMeel:', topMeel); 

  return (
    <div>
      <Slider {...settings}>
        {Array.isArray(topMeel) ? (
          topMeel.map((item, index) => (
            <CarouselItem
              key={index}
              image={item.image}
              title={item.title}
            />
          ))
        ) : (
          <div>No items to display</div>
        )}
      </Slider>
    </div>
  );
}

export default MultiItemCarousel;
