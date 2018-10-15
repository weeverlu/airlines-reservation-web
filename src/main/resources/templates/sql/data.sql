INSERT INTO airlines_node (gmt_created, gmt_modified, airline_num, plane_model, num_firstclass, num_economy,
                           price_firstclass, price_economy, departure_port, departure_time, arrival_port, arrival_time, creator, modifier)
VALUES ('2018-10-11 12:00:00', '2018-10-11 12:00:00', 'AA1101', 'A330', 100, 200, 300, 100, 'LAX', '2018-10-12 10:00(PST)',
                               'NYC', '2018-10-12 17:00(EST)', 'admin', 'admin');
INSERT INTO airlines_node (gmt_created, gmt_modified, airline_num, plane_model, num_firstclass, num_economy,
                           price_firstclass, price_economy, departure_port, departure_time, arrival_port, arrival_time, creator, modifier)
VALUES ('2018-10-11 12:00:00', '2018-10-11 12:00:00', 'AA1102', 'A330', 100, 200, 300, 100, 'LAX', '2018-10-12 10:00(PST)',
                               'NYC', '2018-10-12 17:00(EST)', 'admin', 'admin');
INSERT INTO airlines_node (gmt_created, gmt_modified, airline_num, plane_model, num_firstclass, num_economy,
                           price_firstclass, price_economy, departure_port, departure_time, arrival_port, arrival_time, creator, modifier)
VALUES ('2018-10-11 12:00:00', '2018-10-11 12:00:00', 'AA1103', 'A330', 100, 200, 300, 100, 'LAX', '2018-10-12 10:00(PST)',
                               'NYC', '2018-10-12 17:00(EST)', 'admin', 'admin');

INSERT INTO seats_node (gmt_created, gmt_modified, airline_num, plane_model, guest_first_name, guest_last_name, guest_age,
                        seat_num, price, seat_type, creator, modifier)
VALUES ('2018-10-11 12:00:00', '2018-10-11 12:00:00', 'AA1101', 'A330', 'John', 'Snow', 28, '01A', 300, 1, 'admin', 'admin');
INSERT INTO seats_node (gmt_created, gmt_modified, airline_num, plane_model, guest_first_name, guest_last_name, guest_age,
                        seat_num, price, seat_type, creator, modifier)
VALUES ('2018-10-11 12:00:00', '2018-10-11 12:00:00', 'AA1101', 'A330', 'Tony', 'Stark', 28, '03A', 100, 0, 'admin', 'admin');