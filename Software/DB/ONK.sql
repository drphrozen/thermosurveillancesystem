-- phpMyAdmin SQL Dump
-- version 2.9.1.1
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Generation Time: Apr 17, 2008 at 04:59 AM
-- Server version: 5.0.27
-- PHP Version: 5.2.0
-- 
-- Database: `onk`
-- 

-- --------------------------------------------------------

-- 
-- Table structure for table `accounts`
-- 

CREATE TABLE `accounts` (
  `UserID` varchar(50) NOT NULL default '',
  `Pwd` varchar(50) NOT NULL default '',
  `Type` int(1) NOT NULL default '1',
  PRIMARY KEY  (`UserID`,`Pwd`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

-- 
-- Table structure for table `measures`
-- 

CREATE TABLE `measures` (
  `ProbeID` int(8) NOT NULL default '0',
  `TimeStamp` timestamp NOT NULL default '0000-00-00 00:00:00',
  `Data` double NOT NULL default '0',
  `UpperAlarmLevel` double default NULL,
  `LowerAlarmLevel` double default NULL,
  `RSName` varchar(50) NOT NULL,
  PRIMARY KEY  (`ProbeID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

-- 
-- Table structure for table `probe`
-- 

CREATE TABLE `probe` (
  `RSID` int(5) NOT NULL,
  `ProbeID` int(8) NOT NULL auto_increment,
  `Unit` int(1) NOT NULL default '0',
  `UpperAlarmLevel` double default NULL,
  `LowerAlarmLevel` double default NULL,
  PRIMARY KEY  (`RSID`,`ProbeID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=79 ;

-- --------------------------------------------------------

-- 
-- Table structure for table `rs`
-- 

CREATE TABLE `rs` (
  `RSName` varchar(50) collate utf8_unicode_ci NOT NULL,
  `Enabled` tinyint(1) NOT NULL,
  `RSID` int(5) NOT NULL auto_increment,
  PRIMARY KEY  (`RSID`),
  UNIQUE KEY `RSName` (`RSName`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

-- 
-- Table structure for table `units`
-- 

CREATE TABLE `units` (
  `Unit` int(1) NOT NULL auto_increment,
  `UnitText` varchar(50) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`Unit`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=90 ;
