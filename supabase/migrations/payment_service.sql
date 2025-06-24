-- Insert sample payments
INSERT INTO payments (payment_id, user_id, parking_space_id, vehicle_id, amount, status, method, card_number, card_holder_name, transaction_id, description, created_at, processed_at, failure_reason)
VALUES
-- Completed credit card payment
('PAY-001', 101, 201, 301, 15.50, 'COMPLETED', 'CREDIT_CARD', '****1234', 'John Doe', 'TXN-1001', 'Parking fee - Downtown Lot', '2024-06-16 09:30:00', '2024-06-16 09:31:25', NULL),

-- Failed debit card payment
('PAY-002', 102, 202, 302, 12.00, 'FAILED', 'DEBIT_CARD', '****5678', 'Jane Smith', NULL, 'Monthly parking pass', '2024-06-16 10:15:00', NULL, 'Insufficient funds'),

-- Pending digital wallet payment
('PAY-003', 103, NULL, 303, 8.75, 'PENDING', 'DIGITAL_WALLET', NULL, NULL, NULL, 'Event parking', '2024-06-16 11:20:00', NULL, NULL),

-- Processing bank transfer
('PAY-004', 104, 204, NULL, 22.00, 'PROCESSING', 'BANK_TRANSFER', NULL, NULL, 'TXN-1002', 'Airport parking', '2024-06-16 12:45:00', NULL, NULL),

-- Refunded credit card payment
('PAY-005', 105, 205, 305, 15.50, 'REFUNDED', 'CREDIT_CARD', '****9012', 'Bob Johnson', 'TXN-1003', 'Parking refund', '2024-06-15 14:30:00', '2024-06-15 14:35:00', NULL),

-- Completed without vehicle
('PAY-006', 101, 206, NULL, 9.99, 'COMPLETED', 'DEBIT_CARD', '****3456', 'John Doe', 'TXN-1004', 'Bike parking fee', '2024-06-16 15:10:00', '2024-06-16 15:11:30', NULL),

-- Failed digital wallet
('PAY-007', 106, 207, 307, 18.25, 'FAILED', 'DIGITAL_WALLET', NULL, NULL, NULL, 'Premium spot', '2024-06-16 16:05:00', NULL, 'Payment timeout');