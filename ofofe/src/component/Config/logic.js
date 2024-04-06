export const isPresentInFavorites = (favorites, restaurant) => {
  for (let item of favorites) {
    if (item.id === restaurant.id) {
      return true;
    }
  }
  return false;
};
