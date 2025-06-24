-- Insert sample users (passwords are 'password123' encoded with BCrypt)
INSERT INTO users (username, email, password, first_name, last_name, phone_number, role, status, created_at, updated_at) VALUES
('john_doe', 'john.doe@email.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'John', 'Doe', '+1234567890', 'DRIVER', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('jane_smith', 'jane.smith@email.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'Jane', 'Smith', '+1234567891', 'DRIVER', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('mike_wilson', 'mike.wilson@email.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'Mike', 'Wilson', '+1234567892', 'PARKING_OWNER', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('sarah_johnson', 'sarah.johnson@email.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'Sarah', 'Johnson', '+1234567893', 'PARKING_OWNER', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('admin_user', 'admin@spms.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'Admin', 'User', '+1234567894', 'ADMIN', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('bob_brown', 'bob.brown@email.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'Bob', 'Brown', '+1234567895', 'DRIVER', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('alice_davis', 'alice.davis@email.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'Alice', 'Davis', '+1234567896', 'DRIVER', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('tom_garcia', 'tom.garcia@email.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'Tom', 'Garcia', '+1234567897', 'PARKING_OWNER', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insert sample booking history
INSERT INTO booking_history (user_id, parking_space_id, vehicle_id, booking_time, start_time, end_time, status, total_amount, notes) VALUES
(1, 1, 1, CURRENT_TIMESTAMP - INTERVAL '2' DAY, CURRENT_TIMESTAMP - INTERVAL '2' DAY, CURRENT_TIMESTAMP - INTERVAL '1' DAY, 'COMPLETED', 25.0, 'Regular parking session'),
(2, 2, 2, CURRENT_TIMESTAMP - INTERVAL '1' DAY, CURRENT_TIMESTAMP - INTERVAL '1' DAY, CURRENT_TIMESTAMP - INTERVAL '12' HOUR, 'COMPLETED', 40.0, 'Extended parking'),
(1, 3, 1, CURRENT_TIMESTAMP - INTERVAL '6' HOUR, CURRENT_TIMESTAMP - INTERVAL '6' HOUR, NULL, 'ACTIVE', NULL, 'Current parking session'),
(6, 4, 5, CURRENT_TIMESTAMP - INTERVAL '3' DAY, CURRENT_TIMESTAMP - INTERVAL '3' DAY, CURRENT_TIMESTAMP - INTERVAL '2' DAY, 'COMPLETED', 80.0, 'Business district parking'),
(7, 5, 6, CURRENT_TIMESTAMP - INTERVAL '5' HOUR, CURRENT_TIMESTAMP - INTERVAL '5' HOUR, NULL, 'ACTIVE', NULL, 'VIP parking space');