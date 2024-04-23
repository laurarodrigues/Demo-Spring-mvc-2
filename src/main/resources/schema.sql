DROP TABLE IF EXISTS product_category cascade;


     CREATE TABLE product_category (
     id int NOT NULL,
     name varchar(45) DEFAULT NULL,
     PRIMARY KEY (id) );
     
     INSERT INTO product_category VALUES (1,'Aprons'),(2,'Baseball Hats'),(3,'Mugs'),(4,'T-shirts'),(5,'Hat'),(6,'Notebooks'),(7,'Pillows'),(8,'Artwork'),(9,'Cards'),(10,'Tote Bag');




DROP TABLE IF EXISTS robot cascade;

CREATE TABLE robot (
  id int NOT NULL,
  name varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
);


INSERT INTO robot VALUES (1,'Rex'),(2,'Dolores'),(3,'Bubbles'),(4,'Blade'),(5,'Fred'),(6,'Gil'),(7,'Yodel');

DROP TABLE IF EXISTS user_seq cascade;

CREATE TABLE user_seq (
  next_val bigint DEFAULT NULL
);

INSERT INTO user_seq VALUES (501);

DROP TABLE IF EXISTS user_ cascade;

CREATE TABLE user_ (
  id serial NOT NULL,
  date_of_birth varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  favorite_collection varchar(255) DEFAULT NULL,
  gender varchar(255) DEFAULT NULL,
  message_ varchar(255) DEFAULT NULL,
  name_ varchar(255) DEFAULT NULL,
  news_letter bit(1) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS product cascade;

CREATE TABLE product(
  id serial NOT NULL,
  name varchar(255) DEFAULT NULL,
  category_id int DEFAULT NULL,
  robot_id int DEFAULT NULL,
  color varchar(255) DEFAULT NULL,
  image_path varchar(255) DEFAULT NULL,
  rating int DEFAULT NULL,
  no_of_reviews int DEFAULT NULL,
  description varchar(2048) DEFAULT NULL,
  price int DEFAULT NULL,
  PRIMARY KEY (id),
  /*KEY pr_index (id),
  KEY fk_category (category_id),
  KEY fk_robot (robot_id), */
  CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES product_category (id),
  CONSTRAINT fk_robot FOREIGN KEY (robot_id) REFERENCES robot (id));

INSERT INTO product VALUES (1,'Dolores Apron',1,2,'White','/images/products/binaryville-apron-dolores-white.svg',5,130,'Everyone’s a chef in our eco-friendly apron made from 55% organic cotton and 45% recycled polyester. Showcasing your favorite Big Star Collectibles design, the apron is screen-printed in PVC- and phthalate-free inks. Apron measures 24 inches wide by 30 inches long and is easily adjustable around the neck and waist with one continuous strap. Machine-wash warm, tumble-dry low. ',22),(2,'Dolores Artwork',8,2,'White','/images/products/binaryville-artwork-dolores-wood.svg',4,100,'It’s the perfect gift for that one in your life who loves Big Star Collectibles characters—including you! (We highly encourage fans of our products to buy something incredible for their incredible selves.) Our framed artwork is hand-printed on our proprietary triple-layer organic, acid-free cotton stock, and shipped ready to hang in one of our in-house hand-made frames.  ',50),(3,'Dolores Card',9,2,'Yellow','/images/products/binaryville-cards-dolores-front.svg',5,45,'\nBig Star Collectibles trading cards are the cornerstone of our enterprise, and are, by far, the most sought-after of our products. Our deluxe, limited-edition trading cards are printed on our proprietary, textured, triple-layer organic stock. After printing, all cards are silk laminated to better preserve the cards and to best showcase its character and copy. In addition, each of our cards is encased in an acid-free rigid card sleeve to further protect it from UV rays, moisture, and handling.  ',20),(4,'Dolores Hat',5,2,'Black','/images/products/binaryville-hat-dolores-black.svg',5,35,'Cheer the team on in style with our unstructured, low crown, six-panel baseball cap made of 100% organic cotton twill. Featuring our original Big Star Collectibles artwork, screen-printed with PVC- and phthalate-free inks. Complete with matching sewn ventilation eyelets, and adjustable fabric closure.  ',29),(5,'Dolores Mug',3,2,'Black','/images/products/binaryville-mug-dolores-black.svg',5,150,'\nEnjoy your morning coffee or tea in the company of your favorite Big Star Collectible character. Our strong ceramic mug, with its comfortable D-shaped handle, is microwave and dishwasher safe, and available in one size: 11 oz (3.2” diameter x 3.8” h). ',16),(6,'Dolores T-shirt',4,2,'Black','/images/products/binaryville-tshirt-dolores-black.svg',5,100,'Our t-shirts are made from ring-spun, long-staple organic cotton thats ethically sourced from member farms of local organic cotton cooperatives. Original artwork is screen-printed using PVC- and phthalate-free inks. Features crew-neck styling, shoulder-to-shoulder taping, and a buttery soft feel. Machine-wash warm, tumble-dry low. ',26),(7,'Blade Trading Card',9,4,'White','/images/products/lil-monsters-cards-blade-front.svg',4,78,'Big Star Collectibles trading cards are the cornerstone of our enterprise, and are, by far, the most sought-after of our products. Our deluxe, limited-edition trading cards are printed on our proprietary, textured, triple-layer organic stock. After printing, all cards are silk laminated to better preserve the cards and to best showcase its character and copy. In addition, each of our cards is encased in an acid-free rigid card sleeve to further protect it from UV rays, moisture, and handling.  ',20),(8,'Blade Mug',3,4,'Blue','/images/products/lil-monsters-mug-blade-blue.svg',5,34,'Enjoy your morning coffee or tea in the company of your favorite Big Star Collectible character. Our strong ceramic mug, with its comfortable D-shaped handle, is microwave and dishwasher safe, and available in one size: 11 oz (3.2” diameter x 3.8” h). ',16),(9,'Blade Notebook',6,4,'White','/images/products/lil-monsters-notebook-blade.svg',5,12,'Whether you love to write poems in cursive with a fountain pen, sketch with a pencil, or write notes for your next novel with a ballpoint, our notebooks are great accompaniments to your day-to-day work and play. Available with lined, graph, or blank pages, our lay-flat notebooks are made with curl-resistant ever-so-slightly textured smudge-proof paper that’s ideal for your ideas and creations.',18),(10,'Blade Pillow',7,4,'White','/images/products/lil-monsters-pillow-blade.svg',4,67,'Unlike other throw pillows out there, BigStar Collectibles throw pillows are actually meant to be thrown! If you want to throw them, that is. Constructed of our own organic cotton weave, the pillows are stuffed with organic Kapok fibers harvested in April and May in Hawaii when the fruits mature and fall from the trees. 10 percent of each sale is donated to Hawaii’s botanical gardens. ',30),(11,'Blade Poster',8,4,'White','/images/products/lil-monsters-poster-blade.svg',5,23,'What’s better than a Big Star Collectibles character? A Big Star Collectibles character poster! Here’s your chance to get a 11\" x 17\" small poster, 18\" x 24\" medium poster, and a 24\" x 36\" large poster depicting a favorite character, perfect for a dorm room or den. Printed on heavy satin photo paper to bring out the best and brightest colors. Shipped rolled, unless framed. ',15),(12,'Charmaine Artwork',8,3,'Black','/images/products/stargazers-artwork-charmaine-black.svg',5,23,'It’s the perfect gift for that one in your life who loves Big Star Collectibles characters—including you! (We highly encourage fans of our products to buy something incredible for their incredible selves.) Our framed artwork is hand-printed on our proprietary triple-layer organic, acid-free cotton stock, and shipped ready to hang in one of our in-house hand-made frames.  ',45),(13,'Charmaine Card',9,3,'Black','/images/products/stargazers-cards-charmaine-front.svg',5,23,'\nBig Star Collectibles trading cards are the cornerstone of our enterprise, and are, by far, the most sought-after of our products. Our deluxe, limited-edition trading cards are printed on our proprietary, textured, triple-layer organic stock. After printing, all cards are silk laminated to better preserve the cards and to best showcase its character and copy. In addition, each of our cards is encased in an acid-free rigid card sleeve to further protect it from UV rays, moisture, and handling. ',20),(14,'Charmaine Tote Bag',10,3,'White','/images/products/stargazers-tote-charmaine.svg',5,67,'Our Big Star Collectibles tote is as versatile as it is cool. Made from fabric created from recycled plastic, the tote combines sustainability, beauty, and strength. Use as a reusable shopping bag at the farmers market, as a heavy-duty tote for business and play, and as a unique and useful fashion item.  ',19),(15,'Charmaine T-shirt',4,3,'Black','/images/products/stargazers-tshirt-charmaine-black.svg',4,12,'Our t-shirts are made from ring-spun, long-staple organic cotton thats ethically sourced from member farms of local organic cotton cooperatives. Original artwork is screen-printed using PVC- and phthalate-free inks. Features crew-neck styling, shoulder-to-shoulder taping, and a buttery soft feel. Machine-wash warm, tumble-dry low. ',26),(16,'Fred Mug',3,5,'Black','/images/products/binaryville-mug-fred-black.svg',5,56,'Enjoy your morning coffee or tea in the company of your favorite Big Star Collectible character. Our strong ceramic mug, with its comfortable D-shaped handle, is microwave and dishwasher safe, and available in one size: 11 oz (3.2” diameter x 3.8” h). ',17),(17,'Gil Tote Bag',10,6,'White','/images/products/stargazers-tote-gil-white.svg',4,23,'Our Big Star Collectibles tote is as versatile as it is cool. Made from fabric created from recycled plastic, the tote combines sustainability, beauty, and strength. Use as a reusable shopping bag at the farmers market, as a heavy-duty tote for business and play, and as a unique and useful fashion item.  ',19),(18,'Fred Apron',1,5,'Black','/images/products/binaryville-apron-fred-white.svg',5,123,'Everyone’s a chef in our eco-friendly apron made from 55% organic cotton and 45% recycled polyester. Showcasing your favorite Big Star Collectibles design, the apron is screen-printed in PVC- and phthalate-free inks. Apron measures 24 inches wide by 30 inches long and is easily adjustable around the neck and waist with one continuous strap. Machine-wash warm, tumble-dry low. ',22),(19,'Fred Hat',5,5,'Black','/images/products/binaryville-hat-fred-black.svg',4,47,'Cheer the team on in style with our unstructured, low crown, six-panel baseball cap made of 100% organic cotton twill. Featuring our original Big Star Collectibles artwork, screen-printed with PVC- and phthalate-free inks. Complete with matching sewn ventilation eyelets, and adjustable fabric closure. ',29),(20,'Yodel Pillow',7,7,'White','/images/products/lil-monsters-pillow-yodel.svg',5,667,'Unlike other throw pillows out there, BigStar Collectibles throw pillows are actually meant to be thrown! If you want to throw them, that is. Constructed of our own organic cotton weave, the pillows are stuffed with organic Kapok fibers harvested in April and May in Hawaii when the fruits mature and fall from the trees. 10 percent of each sale is donated to Hawaii’s botanical gardens. ',30),(21,'Yodel Notebook',6,7,'White','/images/products/lil-monsters-notebook-yodel-white.svg',5,23,'Whether you love to write poems in cursive with a fountain pen, sketch with a pencil, or write notes for your next novel with a ballpoint, our notebooks are great accompaniments to your day-to-day work and play. Available with lined, graph, or blank pages, our lay-flat notebooks are made with curl-resistant ever-so-slightly textured smudge-proof paper that’s ideal for your ideas and creations.',18);
