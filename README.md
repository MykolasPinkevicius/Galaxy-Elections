# Galaxy-Elections
Back-End service for 20005 galaxy elections

Year 20005 Galaxy president election took in place today, United States President Elections of 1900 contenders,
reincarnated in AI based functional robots fights again one more time in Milky Way Galaxy Presidential elections.

# Services

**Candidate**

* **URL**
/candidates

* **Method**
GET

* **URL parameters**
None

**Voter**

* **URL**
/voters

* **Method**
POST

* **URL parameters**
None

* **DataParameters**
object Voter -< String id identification, object Ballot -< enum Candidate, enum GalaxyRegion.

Example `{
  "id": 38908090193,
  "ballot": {
    "candidate": "ADLAI_STEVENSON",
    "galaxyRegion": "NUCLEUS"
  }
}`

**Election**

**Overal Distribution Of Votes**

* **URL**
/election/overallVotesDistribution

* **Method**
GET

* **URL parameters**
None

**Current overall votes distribution by region**

* **URL**
/election/overallByRegion

* **Method**
GET

* **URL parameters**
None

**Returns candidate if he won by more than 50% else returns two who got the most votes**

* **URL**
/election/finishElection

* **Method**
GET

* **URL parameters**
None



# **Candidates**
ADLAI_STEVENSON, CHARLES_A_TOWNE, ELLIOT_DANFORTH, WILLIAM_SULZER, JOSEPH_C_SIBLEY, ROBERT_E_PATTISON, THEODORE_ROOSEVELT, WILLIAM_MCKINLEY

# **GalaxyRegions**
NUCLEUS, CENTRAL_BULGE, THIN_DISK, THICK_DISK, SPIRAL_ARMS, SPHERICAL_COMPONENT, MASSIVE_HALO


