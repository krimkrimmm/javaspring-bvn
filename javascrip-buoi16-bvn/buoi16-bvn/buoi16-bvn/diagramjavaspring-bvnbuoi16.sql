Table countries {
  id int [PK]
  name varchar
}

Table movies 
{
  id int [PK]
  name varchar
  slug varchar
  description text
  poster varchar
  release_year int
  rating double
  type movie_type
  status boolean
  
  trailer varchar
  country_id int [ref: > countries.id]  // Bây giờ sẽ không báo lỗi
  created_at datetime
  updated_at datetime
}







