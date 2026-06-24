-- Optional seed data for local testing.

INSERT INTO location (location_name) VALUES
    ('Malappuram'), ('Kozhikode'), ('Ernakulam'), ('Thrissur');

INSERT INTO vehicle_type (type_name) VALUES
    ('Car'), ('Bike'), ('Truck');

INSERT INTO model_year (year, arabic) VALUES
    ('2020', ''), ('2021', ''), ('2022', ''), ('2023', '');

INSERT INTO maker (maker_name, maker_image_url, type) VALUES
    ('Toyota', '', '1'), ('Honda', '', '1'), ('Suzuki', '', '2');

INSERT INTO model (type, year, maker_id, model_name, model_image_url) VALUES
    ('1', '2020', '1', 'Corolla', ''),
    ('1', '2021', '1', 'Camry', ''),
    ('1', '2020', '2', 'Civic', '');

INSERT INTO part (type, year, maker_id, model_id, part_name, part_description) VALUES
    ('1', '2020', '1', '1', 'Brake Pad', 'Front brake pad'),
    ('1', '2020', '1', '1', 'Headlight', 'OEM headlight');

INSERT INTO subpart (type, year, maker_id, model_id, part_id, subpart_name, description) VALUES
    ('1', '2020', '1', '1', '1', 'Brake Sensor', 'Wear sensor');

INSERT INTO custom_ad (adurl, status, outurl) VALUES
    ('https://example.com/ad1.jpg', '1', 'https://example.com');

INSERT INTO suggestion (search) VALUES
    ('brake pad'), ('headlight'), ('mirror');

INSERT INTO app_user (username, mobile, email, location_id, location, type, status, app_id)
VALUES ('Test User', '9876543210', 'test@example.com', '1', 'Malappuram', '1', '1', '1');
