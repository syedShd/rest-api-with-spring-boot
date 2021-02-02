CREATE TABLE `hibernate_sequence` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `employee` (
                            `id` int(11) NOT NULL,
                            `email` varchar(255) DEFAULT NULL,
                            `gender` varchar(255) DEFAULT NULL,
                            `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `employee_skill_set` (
                                      `employee_id` int(11) NOT NULL,
                                      `skill_set` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `address` (
                           `id` bigint(20) NOT NULL,
                           `city` varchar(255) DEFAULT NULL,
                           `door_no` varchar(255) DEFAULT NULL,
                           `postal_code` varchar(255) DEFAULT NULL,
                           `state` varchar(255) DEFAULT NULL,
                           `street` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `emp_contact` (
                               `id` int(11) NOT NULL,
                               `email` varchar(255) DEFAULT NULL,
                               `first_name` varchar(255) DEFAULT NULL,
                               `last_name` varchar(255) DEFAULT NULL,
                               `mobile` varchar(255) DEFAULT NULL,
                               `address_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE `address`
    ADD PRIMARY KEY (`id`);

ALTER TABLE `employee`
    ADD PRIMARY KEY (`id`);

ALTER TABLE `employee_skill_set`
    ADD KEY `FKkmxfyiwfvruiyindr2a023926` (`employee_id`);


ALTER TABLE `emp_contact`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKqv372a0aaywkx5dyg1tadxd3h` (`address_id`);


ALTER TABLE `address`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `emp_contact`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;


ALTER TABLE `employee_skill_set`
    ADD CONSTRAINT `FKkmxfyiwfvruiyindr2a023926` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

ALTER TABLE `emp_contact`
    ADD CONSTRAINT `FKqv372a0aaywkx5dyg1tadxd3h` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`);
COMMIT;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);
