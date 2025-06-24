-- Insert sample parking spaces
INSERT INTO parking_spaces (space_number, location, zone, city, status, type, hourly_rate, owner_id, last_updated) VALUES
('A001', 'Downtown Mall', 'Zone A', 'New York', 'AVAILABLE', 'REGULAR', 5.0, 'owner1', CURRENT_TIMESTAMP),
('A002', 'Downtown Mall', 'Zone A', 'New York', 'OCCUPIED', 'REGULAR', 5.0, 'owner1', CURRENT_TIMESTAMP),
('A003', 'Downtown Mall', 'Zone A', 'New York', 'AVAILABLE', 'DISABLED', 5.0, 'owner1', CURRENT_TIMESTAMP),
('B001', 'Business District', 'Zone B', 'New York', 'AVAILABLE', 'REGULAR', 8.0, 'owner2', CURRENT_TIMESTAMP),
('B002', 'Business District', 'Zone B', 'New York', 'RESERVED', 'VIP', 15.0, 'owner2', CURRENT_TIMESTAMP),
('C001', 'Airport Terminal', 'Zone C', 'Los Angeles', 'AVAILABLE', 'REGULAR', 10.0, 'owner3', CURRENT_TIMESTAMP),
('C002', 'Airport Terminal', 'Zone C', 'Los Angeles', 'AVAILABLE', 'ELECTRIC', 12.0, 'owner3', CURRENT_TIMESTAMP),
('D001', 'Shopping Center', 'Zone D', 'Chicago', 'AVAILABLE', 'REGULAR', 6.0, 'owner4', CURRENT_TIMESTAMP),
('D002', 'Shopping Center', 'Zone D', 'Chicago', 'OUT_OF_ORDER', 'REGULAR', 6.0, 'owner4', CURRENT_TIMESTAMP),
('E001', 'University Campus', 'Zone E', 'Boston', 'AVAILABLE', 'REGULAR', 3.0, 'owner5', CURRENT_TIMESTAMP);