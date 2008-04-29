-- 
-- Table structure for table `account`
-- 

CREATE TABLE `account` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) character set latin1 collate latin1_danish_ci NOT NULL default '',
  `password` varchar(45) character set latin1 collate latin1_danish_ci NOT NULL default '',
  `accounttype` enum('admin','user','readingstation') NOT NULL default 'user',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;


-- 
-- Table structure for table `measurement`
-- 

CREATE TABLE `measurement` (
  `timestamp` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `Probe_idProbe` int(10) unsigned NOT NULL default '0',
  `lowerAlarm` double default NULL,
  `upperAlarm` double default NULL,
  `value` double NOT NULL default '0',
  PRIMARY KEY  (`timestamp`,`Probe_idProbe`),
  KEY `Measurement_FKIndex1` (`Probe_idProbe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;


-- 
-- Table structure for table `probe`
-- 

CREATE TABLE `probe` (
  `idProbe` int(10) unsigned NOT NULL auto_increment,
  `ReadingStation_idReadingStation` int(10) unsigned NOT NULL default '0',
  `lowerAlarm` double default NULL,
  `upperAlarm` double default NULL,
  `units` enum('celsius','bar') collate latin1_danish_ci default NULL,
  PRIMARY KEY  (`idProbe`),
  KEY `Probe_FKIndex1` (`ReadingStation_idReadingStation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci AUTO_INCREMENT=32 ;


-- 
-- Table structure for table `readingstation`
-- 

CREATE TABLE `readingstation` (
  `idReadingStation` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) collate latin1_danish_ci NOT NULL default '',
  `enabled` tinyint(1) NOT NULL default '0',
  PRIMARY KEY  (`idReadingStation`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci AUTO_INCREMENT=38 ;

-- 
-- Constraints for dumped tables
-- 

-- 
-- Constraints for table `measurement`
-- 
ALTER TABLE `measurement`
  ADD CONSTRAINT `measurement_ibfk_1` FOREIGN KEY (`Probe_idProbe`) REFERENCES `probe` (`idProbe`) ON DELETE CASCADE ON UPDATE NO ACTION;

-- 
-- Constraints for table `probe`
-- 
ALTER TABLE `probe`
  ADD CONSTRAINT `probe_ibfk_1` FOREIGN KEY (`ReadingStation_idReadingStation`) REFERENCES `readingstation` (`idReadingStation`) ON DELETE CASCADE ON UPDATE NO ACTION;
