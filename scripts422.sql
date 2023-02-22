
CREATE TABLE car (id text UNIQUE PRIMARY KEY,car_brand VARCHAR(50) NOT NULL, car_model VARCHAR(50) NOT NULL, the_cost_of_a_car INT NOT NULL);

CREATE TABLE people (id_people INT UNIQUE PRIMARY KEY,name_People VARCHAR(50) NOT NULL, age_People INT NOT NULL, auto_right BOOLEAN NOT NULL,id_car text REFERENCES car (id) );


