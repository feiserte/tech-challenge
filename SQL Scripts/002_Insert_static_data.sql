/************************************************************************************************
* Hardcode inserts
* Insert static data
* Author: felipe@dvdsp.com.br
* Last update date: March 16 of 2018 - 11:20
************************************************************************************************/
Use techChallengeDb;

INSERT INTO Customer (
    email,
    name,
    address,
    creation,
    password
) VALUES (
	'felipe@dvdsp.com.br',
    'Felipe',
    '123 street',
    '2018-16-03 11:22',
    '1234'
    
);

INSERT INTO Products (
	restaurantID,
    name,
    description,
    price

) VALUES
(
	1,
    'Cheese pizza',
    'Delicious pizza!',
    8.35
);

INSERT INTO Products (
	restaurantID,
    name,
    description,
    price

) VALUES
(
	1,
    'Pepperoni pizza',
    'Chef choice pizza!',
    8.85
);


INSERT INTO Restaurant (
    name,
    description,
    address,
	longitude,
	lagitude
    
) VALUES (
	'Zorbas Pizza',
    'Best pizza ever!',
    'Market Rd.',
    -97.130940,
    49.887374
);

INSERT INTO Restaurant (
    name,
    description,
    address,
	longitude,
	lagitude
    
) VALUES (
	'Chosabi',
    'Fast. Casual. Fresh. At Chosabi we love convenience and keeping things simple, but most of all, we love food.',
    'Portage Ave.',
    -97.141520,
    49.898128
);
