# Domain Model #

### **Rationale to identify associations between conceptual classes**


| Concept (A) 	                  |  Association   	      | Concept (B)                  |
|:----------:	                  |:-------------:	      |:---------:                   |
| Company                         | own             	  | Ships                        |
|                                 | own             	  | Truck                        |
|                                 | have             	  | TrafficManager               |
| Containers                      | related to      	  | CargoManifest                |
|                                 | store            	  | Ports                        |
|                                 | store            	  | Warehouse                    |
| Ships                           | transport        	  | Containers                   |
|                                 | dock            	  | Ports                        |
|                                 | has             	  | ShipPosition                 |
| TrafficManager                  | controls         	  | ShipPosition                 |
| Truck                           | transport       	  | Containers                   |
|                                 | park            	  | Warehouse                    |
