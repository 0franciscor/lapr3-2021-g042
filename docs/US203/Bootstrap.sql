-- Bootstrap of Ships
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('303221000', 'IMO7819216', 174, 568.41, 'WDG5171', 3, 'ARCTIC SEA', 30, 37, 9, 'NA', 125.27);
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('303267000', 'IMO6421086', 281, 601.18, 'WNGW', 4.4, 'TUSTUMENA', 60, 89, 18, 'NA', 278.36);
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('256888000', 'IMO9473028', 110, 615.46, '9HA2954', 14.7, 'CMA CGM MELISANDE', 70, 334, 42, '70', 275.43);
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('229857000', 'IMO9224726', 187, 98.78, '9HA3667', 7.8, 'CARNIVAL LEGEND', 60, 292, 38, 'NA', 54.02);
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('210950000', 'IMO9395044', 300, 296.83, 'C4SQ2', 9.5, 'VARAMO', 70, 166, 25, 'NA', 112.2);
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('256304000', 'IMO9344564', 8, 628.1, '9HA3880', 11.4, 'OREGON TRADER', 70, 211, 29, 'NA', 210.33);
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('212180000', 'IMO9643544', 415, 70.05, '5BBA4', 14.4, 'SAITA I', 70, 228, 32, 'NA', 178.56);
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('305776000', 'IMO9506758', 142, 494.25, 'V2FR9', 8.5, 'INDUSTRIAL FAITH', 70, 153, 23, 'NA', 257.37);
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('228339600', 'IMO9450648', 490, 325.74, 'FLSU', 15, 'CMA CGM ALMAVIVA', 70, 334, 42, '79', 75.39);
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('636092932', 'IMO9225641', 447, 241.1, 'D5VK6', 11.8, 'MSC ILONA', 79, 299, 40, '79', 44.66);
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('235092459', 'IMO9517575', 157, 390.62, '2FMJ5', 12, 'STENA ICEMAX', 90, 227, 42, 'NA', 202.86);
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('636019825', 'IMO9222285', 253, 225.63, 'D5WI6', 9.2, 'CONTI LYON', 79, 300, 40, '79', 214.64);
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('249047000', 'IMO9192387', 116, 552.35, '9HJC9', 8, 'CELEBRITY SUMMIT', 60, 294, 32, 'NA', 89.23);
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('305176000', 'IMO9344394', 59, 66.27, 'V2DD5', 5.6, 'CELIA', 70, 100, 15, '70', 172.36);
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('257881000', 'IMO9701920', 228, 601.04, 'LATO7', 13.3, 'SPAR ARIES', 70, 199, 32, 'NA', 63.23);
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('309416000', 'IMO9417086', 203, 211.8, 'C6XC6', 6.4, 'SEABOURN ODYSSEY', 60, 198, 26, 'NA', 4.78);
insert into Ship (mmsiCode, imoCode, numberEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo, capacity) values ('229961000', 'IMO9700122', 72, 387.9, '9HA3752', 13.3, 'ARABELLA', 70, 199, 32, 'NA', 67.21);

--Bootstrap ShipLocation
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/11/2021', '42.97875', '-66.97001', 12.9, 13.1, '355', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/4/2021', '42.92236', '-66.97243', 12.5, 2.4, '358', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/11/2021', '42.7698', '-66.9759', 13.3, 3.7, '356', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/11/2021', '42.96912', '-66.97061', '12.7', '-55.4', '358', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/8/2021', '42.95969', '-66.97106', 12.9, 8.1, '358', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/12/2021', '42.82021', '-66.9758', 13, -55, '356', '0', 'A');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/14/2021', '42.84366', '-66.97571', 13, -49.7, '356', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/3/2021', '42.69577', '-66.97808', 13.7, -54.8, '357', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/15/2021', '42.93874', '-66.97208', 13.1, 2.6, '359', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/4/2021', '42.73879', '-66.97726', 13.4, 3.4, '357', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/13/2021', '42.96527', '-66.97082', 12.8, -58.6, '358', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/3/2021', '42.77682', '-66.9756', 13.2, -53.3, '358', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/9/2021', '42.94963', '-66.97151', 13.4, 16.3, '358', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/13/2021', '42.81133', '-66.97587', 13.4, 10, '356', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/4/2021', '42.75527', '-66.97665', 13.7, -50.5, '357', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/6/2021', '42.71055', '-66.97776', 13.5, 1.4, '358', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/13/2021', '43.02665', '-66.97076', 12.5, 3.6, '354', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/3/2021', '42.9442', '-66.97192', 13.3, 4.2, '358', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/10/2021', '42.90195', '-66.97326', 12.8, 5.9, '357', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/14/2021', '43.22513', '-66.96725', 11.7, 5.5, '355', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/3/2021', '42.75007', '-66.97689', 13.6, 3, '357', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/5/2021', '42.8839', '-66.97409', 12.7, 2.5, '359', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/16/2021', '42.82527', '-66.97577', 13.1, -50.9, '356', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/5/2021', '42.7969', '-66.97547', 13, 4.2, '356', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('210950000', '12/8/2021', '42.98271', '-66.97009', 12.4, -52, '354', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('212180000', '12/5/2021', '24.34573', '-85.12394', 11.7, 119.9, '117', '3', 'A');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('212180000', '12/12/2021', '24.14301', '-84.72268', 11.7, 116.6, '114', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('212180000', '12/6/2021', '24.28016', '-85.00316', 11.3, 120.8, '118', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('212180000', '12/6/2021', '24.20221', '-84.85411', 11.3, 116.8, '117', '0', 'A');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('212180000', '12/15/2021', '24.11445', '-84.65529', 11.6, 113.3, '110', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('212351000', '12/11/2021', '55.09307', '-167.63625', 3.5, -61.6, '232', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/8/2021', '28.30354', '-88.78563', 11.7, 129.9, '131', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/5/2021', '28.08366', '-88.50578', 11.5, 131, '131', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/7/2021', '28.32168', '-88.81035', 11.7, 128.3, '130', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/7/2021', '28.33263', '-88.82491', 11.8, 129.5, '131', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/16/2021', '28.19854', '-88.65058', 11.7, 130.3, '131', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/6/2021', '27.89788', '-88.25001', 11.7, 128.4, '129', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/10/2021', '28.19528', '-88.64645', 11.7, 130.8, '131', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/3/2021', '28.34134', '-88.83706', 11.9, 126.9, '129', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/5/2021', '27.95776', '-88.33859', 11.3, 128.2, '128', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/7/2021', '28.3484', '-88.84688', 12, 129, '130', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/3/2021', '28.34412', '-88.84108', 12, 128.3, '129', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/7/2021', '28.35085', '-88.85024', 12, 127.3, '130', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/3/2021', '28.26076', '-88.7299', 11.8, 131, '131', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/8/2021', '28.33618', '-88.82967', 11.9, 127.8, '131', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/4/2021', '28.05221', '-88.46678', 11.6, 130.9, '131', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/11/2021', '28.10335', '-88.53051', 11.6, 130.5, '131', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/7/2021', '28.37458', '-88.88584', 11.8, 124.6, '128', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/16/2021', '27.87869', '-88.22321', 11.7, 127.9, '128', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('228339600', '12/15/2021', '28.05475', '-88.46992', 11.5, 131.1, '131', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('229767000', '12/14/2021', '26.45021', '-91.84957', 19.4, -111.4, '297', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('229767000', '12/6/2021', '26.44508', '-91.83885', 19.4, -111.7, '296', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('229767000', '12/5/2021', '26.12391', '-91.18216', 20.1, -109.7, '299', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('229767000', '12/8/2021', '26.12964', '-91.19356', 20.1, -110.9, '299', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('229857000', '12/7/2021', '17.9662', '-63.14557', 1.3, 155.3, '88', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('229857000', '12/8/2021', '17.94857', '-63.14243', 0.9, 145.9, '88', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('229857000', '12/8/2021', '17.96995', '-63.14873', 1.4, 131.9, '78', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('229857000', '12/16/2021', '17.96373', '-63.14453', 1.2, 155, '85', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('229857000', '12/11/2021', '17.95542', '-63.142', 0.9, 194.5, '78', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('229961000', '12/13/2021', '54.23188', '-130.33667', 0.1, 82.8, '0', '0', 'A');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('229961000', '12/7/2021', '54.23184', '-130.33702', 0.1, 34.6, '0', '1', 'A');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('235092459', '12/6/2021', '23.27468', '-79.12974', 0.2, 143.9, '111', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('249047000', '12/16/2021', '25.74779', '-78.29992', 0, -100.1, '139', '3', 'A');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('249047000', '12/10/2021', '25.74787', '-78.29997', 0.1, 173.9, '142', '0', 'A');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('249047000', '12/12/2021', '25.74754', '-78.29966', 0.1, -170.3, '123', '2', 'A');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('249047000', '12/5/2021', '25.74774', '-78.29988', 0, 30, '138', '1', 'A');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('249047000', '12/3/2021', '25.74784', '-78.29996', 0, 165.3, '142', '2', 'A');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('249047000', '12/16/2021', '25.74774', '-78.29988', 0.1, -58, '139', '0', 'A');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('249047000', '12/12/2021', '25.74763', '-78.29975', 0, -91.7, '130', '1', 'A');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('249047000', '12/6/2021', '25.74757', '-78.29971', 0.1, -62.3, '124', '2', 'A');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('256304000', '12/10/2021', '24.0902', '-84.93642', 4.8, -145.4, '259', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('256888000', '12/13/2021', '27.0003', '-91.62468', 14.8, -93.6, '314', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('256888000', '12/14/2021', '27.00352', '-91.62823', 14.7, -95.6, '314', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('256888000', '12/6/2021', '26.99882', '-91.62308', 14.7, -94.6, '315', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('256888000', '12/10/2021', '27.01087', '-91.63685', 14.7, -95.6, '314', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('256888000', '12/4/2021', '26.9937', '-91.61775', 14.8, -91.6, '316', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('256888000', '12/15/2021', '26.92217', '-91.5435', 15, -93.6, '314', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('256888000', '12/5/2021', '27.00748', '-91.63287', 14.7, -96.6, '313', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('257881000', '12/10/2021', '23.90519', '-84.15083', 13.2, 118.1, '117', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('257881000', '12/16/2021', '24.2153', '-84.80182', 12.2, 117.7, '113', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('257881000', '12/15/2021', '23.94399', '-84.23724', 13.2, 116.6, '113', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('257881000', '12/4/2021', '24.20834', '-84.78753', 12.2, 118.3, '113', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('257881000', '12/4/2021', '24.23369', '-84.84026', 12, 117.2, '113', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('257881000', '12/7/2021', '24.16206', '-84.69464', 12.1, 117.5, '112', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('258692000', '12/10/2021', '27.86118', '-78.01013', 10.4, 73, '77', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('258692000', '12/14/2021', '27.80105', '-78.239', 10.3, 72, '78', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('258692000', '12/10/2021', '27.78238', '-78.30668', 10.4, 72, '78', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('258692000', '12/10/2021', '27.79408', '-78.26433', 10.3, 72, '78', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('258692000', '12/9/2021', '27.79903', '-78.24627', 10.3, 73, '78', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('258692000', '12/12/2021', '27.83305', '-78.12255', 10.2, 74, '80', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('258692000', '12/7/2021', '27.79535', '-78.25963', 10.3, 73, '78', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('258692000', '12/10/2021', '27.85187', '-78.04922', 10.5, 74, '80', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('258692000', '12/12/2021', '27.83512', '-78.1149', 10.3, 73, '80', '2', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('258692000', '12/4/2021', '27.78335', '-78.30307', 10.4, 73, '78', '3', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('258692000', '12/7/2021', '27.85623', '-78.03073', 10.5, 76, '80', '0', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('258692000', '12/7/2021', '27.82815', '-78.13885', 10.3, 71, '77', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('258692000', '12/10/2021', '27.80468', '-78.22573', 10.2, 72, '78', '1', 'B');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('258692000', '12/10/2021', '27.77507', '-78.33393', 10.4, 74, '78', '3', 'A');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('303221000', '12/13/2021', '53.87876', '-166.55202', 0, -188.8, '511', '2', 'A');
insert into ShipLocation (shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values ('303221000', '12/11/2021', '53.87878', '-166.55203', 0, -197.3, '511', '2', 'A');

-- Bootstrap Countries
Insert into Country (COUNTRYNAME,CONTINENT) values ('United Kingdom','Europe');
Insert into Country (COUNTRYNAME,CONTINENT) values ('United States','America');
Insert into Country (COUNTRYNAME,CONTINENT) values ('Brazil','America');
Insert into Country (COUNTRYNAME,CONTINENT) values ('Canada','America');
Insert into Country (COUNTRYNAME,CONTINENT) values ('Chile','America');
Insert into Country (COUNTRYNAME,CONTINENT) values ('Colombia','America');
Insert into Country (COUNTRYNAME,CONTINENT) values ('France','Europe');
Insert into Country (COUNTRYNAME,CONTINENT) values ('Portugal','Europe');
Insert into Country (COUNTRYNAME,CONTINENT) values ('Spain','Europe');
Insert into Country (COUNTRYNAME,CONTINENT) values ('Peru','America');

--Bootstrap PlaceLocations

Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('53.46666667','-3.033333333','United Kingdom');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('33.71666667','-118.2666667','United States');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('40.66666667','-74.16666667','United States');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('-32.06666667','-52.06666667','Brazil');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('-12.96666667','-38.51666667','Brazil');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('-23.93333333','-46.31666667','Brazil');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('44.65','-63.56666667','Canada');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('49.28333333','-123.1166667','Canada');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('-36.73333333','-73.15','Chile');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('-33.01666667','-71.63333333','Chile');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('3.916666667','-77.05','Colombia');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('10.41666667','-75.53333333','Colombia');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('48.4','-4.5','France');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('51.05','2.366666667','France');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('37.73333333','-25.66666667','Portugal');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('32.65','-16.91666667','Portugal');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('41.18333333','-8.7','Portugal');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('38.5','-8.916666667','Portugal');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('41.33333333','2.166666667','Spain');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('39.45','-0.3','Spain');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('-12.05','-77.16666667','Peru');
Insert into PlaceLocation (LATITUDE,LONGITUDE,COUNTRYNAME) values ('-17','-72.1','Peru');

-- Bootstrap Ports
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('29002','Liverpool','53.46666667','-3.033333333');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('14635','Los Angeles','33.71666667','-118.2666667');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('25007','New Jersey','40.66666667','-74.16666667');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('20301','Rio Grande','-32.06666667','-52.06666667');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('20351','Salvador','-12.96666667','-38.51666667');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('27248','Santos','-23.93333333','-46.31666667');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('22226','Halifax','44.65','-63.56666667');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('25350','Vancouver','49.28333333','-123.1166667');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('27792','San Vicente','-36.73333333','-73.15');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('28082','Valparaiso','-33.01666667','-71.63333333');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('28261','Buenaventura','3.916666667','-77.05');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('28313','Cartagena','10.41666667','-75.53333333');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('18012','Brest','48.4','-4.5');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('18326','Dunkirk','51.05','2.366666667');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('18476','Ponta Delgada','37.73333333','-25.66666667');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('23428','Funchal','32.65','-16.91666667');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('13012','Leixoes','41.18333333','-8.7');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('13390','Setubal','38.5','-8.916666667');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('17386','Barcelona','41.33333333','2.166666667');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('18937','Valencia','39.45','-0.3');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('30045','Callao','-12.05','-77.16666667');
Insert into Ports (ID,NAME,PLACELOCATIONLATITUDE,PLACELOCATIONLONGITUDE) values ('10860','Matarani','-17','-72.1');

--Bootstrap CargoManifestLoad

insert into CARGOMANIFESTLOAD(id,shipmmsiCode,portid) values (1,'210950000', '29002');
insert into CARGOMANIFESTLOAD(id,shipmmsiCode,portid) values (2,'636092932', '29002');
insert into CARGOMANIFESTLOAD(id,shipmmsiCode,portid) values (3,'258692000', '29002');
insert into CARGOMANIFESTLOAD(id,shipmmsiCode,portid) values (4,'229961000', '29002');
insert into CARGOMANIFESTLOAD(id,shipmmsiCode,portid) values (5,'212180000', '29002');
insert into CARGOMANIFESTLOAD(id,shipmmsiCode,portid) values (6,'229857000', '29002');
insert into CARGOMANIFESTLOAD(id,shipmmsiCode,portid) values (7,'636019825', '29002');
insert into CARGOMANIFESTLOAD(id,shipmmsiCode,portid) values (8,'636092932', '29002');
insert into CARGOMANIFESTLOAD(id,shipmmsiCode,portid) values (9,'210950000', '29002');
insert into CARGOMANIFESTLOAD(id,shipmmsiCode,portid) values (10,'636092932', '29002');
insert into CARGOMANIFESTLOAD(id,shipmmsiCode,portid) values (11,'210950000', '29002');


--Bootstrap Ship_Port

INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','210950000');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','212180000');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','212351000');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','228339600');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','229767000');
INSERT INTO Ship_Port(portsid, SHIPMMSICode)
values('29002','229857000');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','229961000');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','235092459');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','249047000');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','256304000');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','256888000');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','257881000');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','258692000');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','303221000');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','303267000');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','305176000');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','305373000');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','305776000');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','309416000');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','636019825');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','636091400');
INSERT INTO Ship_Port(portid, SHIPMMSICode)
values('29002','636092932');


--Bootstrap Phases
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (11,1,'Liverpool','Los Angeles','2021-11-04 18:44:33','2021-12-30 18:44:33','2021-11-04 18:44:33','2021-12-30 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (10,1,'New Jersey','Liverpool','2021-11-04 18:44:33','2021-12-30 18:44:33','2021-11-04 18:44:33','2021-12-30 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (1,1,'Valencia','Callao','2021-10-02 18:44:33','2021-10-15 18:44:33','2021-10-02 18:44:33','2021-10-15 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (1,2,'Callao','Matarani','2021-10-17 18:44:33','2021-10-30 18:44:33','2021-10-17 18:44:33','2021-10-30 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (1,3,'Matarani','New Jersey','2021-11-01 18:44:33','2021-11-03 18:44:33','2021-11-01 18:44:33','2021-11-03 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (1,4,'New Jersey','Liverpool','2021-11-04 18:44:33','2021-12-30 18:44:33','2021-11-04 18:44:33','2021-12-30 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (9,1,'New Jersey','Liverpool','2021-11-04 18:44:33','2021-12-30 18:44:33','2021-11-04 18:44:33','2021-12-30 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (7,1,'Los Angeles','Liverpool','2021-11-04 18:44:33','2021-12-30 18:44:33','2021-11-04 18:44:33','2021-12-30 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (8,1,'Rio Grande','Liverpool','2004-11-03 18:44:33','2004-11-04 18:44:33','2004-11-03 18:44:33','2004-11-04 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (8,2,'Liverpool','Los Angeles','2021-11-04 18:44:33','2021-12-30 18:44:33','2021-11-04 18:44:33','2021-12-30 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (3,1,'Rio Grande','Liverpool','2004-11-03 18:44:33','2004-11-04 18:44:33','2004-11-03 18:44:33','2004-11-04 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (3,2,'Liverpool','Salvador','2004-11-03 18:44:33','2004-11-04 18:44:33','2004-11-03 18:44:33','2004-11-04 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (3,3,'Salvador','Santos','2004-11-03 18:44:33','2004-11-04 18:44:33','2004-11-03 18:44:33','2004-11-04 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (4,1,'Halifax','Vancouver','2004-11-03 18:44:33','2004-11-04 18:44:33','2004-11-03 18:44:33','2004-11-04 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (4,2,'Vancouver','San Vicente','2004-11-03 18:44:33','2004-11-04 18:44:33','2004-11-03 18:44:33','2004-11-04 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (4,3,'San Vicente','Valparaiso','2004-11-03 18:44:33','2004-11-04 18:44:33','2004-11-03 18:44:33','2004-11-04 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (5,1,'Buenaventura','Cartagena','2004-11-03 18:44:33','2004-11-04 18:44:33','2004-11-03 18:44:33','2004-11-04 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (5,2,'Cartagena','Brest','2004-11-03 18:44:33','2004-11-04 18:44:33','2004-11-03 18:44:33','2004-11-04 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (6,1,'Brest','Los Angeles','2004-11-03 18:44:33','2004-11-04 18:44:33','2004-11-03 18:44:33','2004-11-04 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (2,1,'Barcelona','Setubal','2004-11-03 18:44:33','2004-11-04 18:44:33','2004-11-03 18:44:33','2004-11-04 18:44:33');
INSERT INTO Phases(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (2,2,'Setubal','Leixoes','2004-11-07 18:44:33','2004-11-09 18:44:33','2004-11-07 18:44:33','2004-11-09 18:44:33');

--Bootstrap CargoManifestUnload
INSERT INTO cargomanifestunload(id,Phasescargomanifestloadid,Phasesid,portid)
VALUES (2,3,1,'29002');
INSERT INTO cargomanifestunload(id,Phasescargomanifestloadid,Phasesid,portid)
VALUES (3,3,2,'29002');
INSERT INTO cargomanifestunload(id,Phasescargomanifestloadid,Phasesid,portid)
VALUES (4,3,3,'29002');
INSERT INTO cargomanifestunload(id,Phasescargomanifestloadid,Phasesid,portid)
VALUES (5,4,1,'29002');
INSERT INTO cargomanifestunload(id,Phasescargomanifestloadid,Phasesid,portid)
VALUES (6,4,2,'29002');
INSERT INTO cargomanifestunload(id,Phasescargomanifestloadid,Phasesid,portid)
VALUES (7,5,1,'29002');
INSERT INTO cargomanifestunload(id,Phasescargomanifestloadid,Phasesid,portid)
VALUES (8,5,2,'29002');
INSERT INTO cargomanifestunload(id,Phasescargomanifestloadid,Phasesid,portid)
VALUES (1,1,3,'29002');
INSERT INTO cargomanifestunload(id,Phasescargomanifestloadid,Phasesid,portid)
VALUES (10,1,2,'29002');
INSERT INTO cargomanifestunload(id,Phasescargomanifestloadid,Phasesid,portid)
VALUES (11,1,1,'29002');
INSERT INTO cargomanifestunload(id,Phasescargomanifestloadid,Phasesid,portid)
VALUES (9,8,1,'29002');


-- Bootstrap Containers

insert into Container (Numberid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (748323899, 5033407, 'justo', 2.4, 1.5, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 89.9, 1.1, 181.7, 118.5);
insert into Container (Numberid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (223364868, 8150283, 'sagittis', 92.3, 179.3, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 89.6, 20.7, 128.5, 72.1);
insert into Container (Numberid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (633494223, 9081623, 'pellentesque', 26.0, 137.9, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 58.6, 38.5, 195.2, 35.4);
insert into Container (Numberid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (920807949, 2862767, 'tempus', 161.3, 53.9, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 33.1, 88.4, 131.3, 147.8);
insert into Container (Numberid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (149378835, 5033407, 'justo', 2.4, 1.5, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 89.9, 1.1, 181.7, 118.5);
insert into Container (Numberid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (748163149, 8150283, 'sagittis', 92.3, 179.3, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 89.6, 20.7, 128.5, 72.1);
insert into Container (Numberid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (694899744, 9081623, 'pellentesque', 26.0, 137.9, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 58.6, 38.5, 195.2, 35.4);
insert into Container (Numberid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (628015754, 2862767, 'tempus', 161.3, 53.9, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 33.1, 88.4, 131.3, 147.8);
insert into Container (Numberid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (916849354, 5033407, 'justo', 2.4, 1.5, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 89.9, 1.1, 181.7, 118.5);
insert into Container (Numberid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (385553229, 8150283, 'sagittis', 92.3, 179.3, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 89.6, 20.7, 128.5, 72.1);
insert into Container (Numberid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (198620709, 9081623, 'pellentesque', 26.0, 137.9, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 58.6, 38.5, 195.2, 35.4);
insert into Container (Numberid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (205492538, 9081623, 'pellentesque', 26.0, 137.9, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 58.6, 38.5, 195.2, 35.4);
insert into Container (Numberid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (456789423, 9081623, 'pellentesque', 26.0, 137.9, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 58.6, 38.5, 195.2, 35.4);
insert into Container (Numberid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (789546125, 9081623, 'pellentesque', 26.0, 137.9, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 58.6, 38.5, 195.2, 35.4);
insert into Container (Numberid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (213456782, 9081623, 'pellentesque', 26.0, 137.9, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 58.6, 38.5, 195.2, 35.4);
insert into Container (Numberid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (612538123, 9081623, 'pellentesque', 26.0, 137.9, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 58.6, 38.5, 195.2, 35.4);


--Bootstrap CargoManifestContainer

INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid, cargomanifestunloadid)
VALUES (1,456789423,1,12.6,1,1,1,3,2);
INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid, cargomanifestunloadid)
VALUES (1,789546125,1,12.6,1,1,1,3,2);
INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid, cargomanifestunloadid)
VALUES (1,213456782,2,12.6,1,1,1,3,2);
INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid, cargomanifestunloadid)
VALUES (1,748323899,3,12.6,1,1,1,3,2);
INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid, cargomanifestunloadid)
VALUES (3,748323899,1,12.6,1,1,1,3,2);
INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid, cargomanifestunloadid)
VALUES (3,223364868,2,12.6,1,3,1,3,3);
INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid, cargomanifestunloadid)
VALUES (3,633494223,3,12.6,1,2,1,3,4);
INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid, cargomanifestunloadid)
VALUES (4,920807949,1,12.6,1,6,1,4,5);
INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid, cargomanifestunloadid)
VALUES (4,149378835,2,12.6,1,4,1,4,6);
INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid)
VALUES (4,748163149,3,12.6,1,3,1,4);
INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid, cargomanifestunloadid)
VALUES (5,694899744,1,12.6,1,2,1,5,7);
INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid, cargomanifestunloadid)
VALUES (5,628015754,2,12.6,1,1,1,5,8);
INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid)
VALUES (6,916849354,1,12.6,1,1,1,6);
INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid,cargomanifestunloadid)
VALUES (8,385553229,1,12.6,1,1,1,8,9);
INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid )
VALUES (10,198620709,1,12.6,1,1,1,10);
INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid )
VALUES (11,205492538,1,12.6,1,1,1,11);
INSERT INTO CargoManifestContainer(cargomanifestloadid,containerNumberId,Phasesid,grosscontainer,xcontainer,ycontainer,zcontainer, Phasescargomanifestloadid)
VALUES (9,612538123,1,12.6,1,1,1,9);

insert into Container (NUMBERid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (987650321, 1569483, 'justo', 2.4, 1.5, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 89.9, 1.1, 181.7, 118.5);
insert into Container (NUMBERid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (695421863, 8150283, 'sagittis', 92.3, 179.3, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 89.6, 20.7, 128.5, 72.1);

insert into Ship (mmsicode, imocode, NUMBERENERGYGENERATORS, generatoroutput, callsign, draft, shipname, vesseltypeid, shiplength, width, cargo) values ('529467097', 'IMO4419462', 82, 16.8, 'sit', 39.1, 'consequat', 100, 72.2, 61.5, 'in');
insert into Ship (mmsicode, imocode, NUMBERENERGYGENERATORS, generatoroutput, callsign, draft, shipname, vesseltypeid, shiplength, width, cargo) values ('696134988', 'IMO8583481', 57, 20.4, 'abc', 85.6, 'a', 17, 30.5, 16.9, 'magna');

insert into Country (countryname, continent) values ('Indonesia', 'Continent');
insert into Country (countryname, continent) values ('Libya', 'Continent');
insert into Country (countryname, continent) values ('China', 'Continent');
insert into Country (countryname, continent) values ('Montenegro', 'Continent');

insert into PlaceLocation (countryname, latitude, longitude) values ('Indonesia', '70', '-93');
insert into PlaceLocation (countryname, latitude, longitude) values ('Libya', '61', '41');
insert into PlaceLocation (countryname, latitude, longitude) values ('China', '62', '145');
insert into PlaceLocation (countryname, latitude, longitude) values ('Montenegro', '-16', '-99');

insert into PORTS (id, name, PLACELOCATIONLATITUDE, PLACELOCATIONlongitude) values (117638542, 'sapien', '70', '-93');
insert into PORTS (id, name, PLACELOCATIONLATITUDE, PLACELOCATIONlongitude) values (29536752, 'eget', '61', '41');
insert into PORTS (id, name, PLACELOCATIONLATITUDE, PLACELOCATIONlongitude) values (937194604, 'nec', '62', '145');

insert into CARGOMANIFESTLOAD(id,shipmmsicode,portid) values (10000,'529467097', 117638542);
insert into CARGOMANIFESTLOAD(id,shipmmsicode,portid) values (20000,'696134988', 29536752);

INSERT INTO PHASES(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (20000,1,'eget','nec','2021-11-04 18:44:33','2021-12-30 18:44:33','2021-11-04 18:44:33','2021-12-30 18:44:33');

INSERT INTO cargomanifestunload(id,phasescargomanifestloadid,phasesid,portid)
VALUES (951245368,20000,1,937194604);

INSERT INTO cargoManifestContainer(cargomanifestloadid,containernumberid,grosscontainer,xcontainer,ycontainer,zcontainer,PhasesId,PhasesCargoManifestLoadId )
VALUES (10000,987650321,12.6,1,1,1,1,10000);

INSERT INTO cargoManifestContainer(cargomanifestloadid,containernumberid,grosscontainer,xcontainer,ycontainer,zcontainer,PhasesId,PhasesCargoManifestLoadId,CargoManifestUnloadId)
VALUES (20000,695421863,12.6,1,3,1,1,20000,951245368);