Story 1
AC1
Given a parking lot, and a car, when park the car, then return a parking ticket.
Given a parking lot with a parked car, and a ticket, when fetch the car, them return the parked car.
AC2
Given a parking lot, two cars, and two tickets, when fetch the car twice, them return corresponding cars.
AC3
Given a parking lot, and a wrong ticket, when fetch the car, then return null.
Given a parking lot, and no ticket, when fetch the car, then return null.
AC4
Given a parking lot, and a used ticket, when fetch the car, then return null.
AC5
Given a full parking lot, and a car, when park the car, then return null.

Story 2
AC1
Given a parking lot, and a wrong ticket, when fetch the car, then return null, and throw "Unrecognized parking ticket".
Given a parking lot, and a used ticket, when fetch the car, then return null, and throw "Unrecognized parking ticket".
AC2
Given a full parking lot, and a car, when park the car, then return null, and throw "No available position".

Story 3
Given a parking lot, a parking boy, and a car, when park the car, then return a parking ticket.
Given a parking lot with a parked car, a parking boy, and a ticket, when fetch the car, them return the parked car.
Given a parking lot, a parking boy, two cars, and two tickets, when fetch the car twice, them return corresponding cars.
Given a parking lot, a parking boy, and a wrong ticket, when fetch the car, then return null, and throw "Unrecognized parking ticket".
Given a parking lot, a parking boy, and a used ticket, when fetch the car, then return null, and throw "Unrecognized parking ticket".
Given a full parking lot, a parking boy, and a car, when park the car, then return null, and throw "No available position".

Story 4
Given two empty parking lots, a parking boy, and a car, when park the car, then return a parking ticket.
Given first full parking lot and second parking lot with available positions, a parking boy, and a car, when park the car, then return a parking ticket.
Given two parking lots with a parked car each, a parking boy, two cars, and two tickets, when fetch the car twice, then return corresponding cars.
Given two parking lots, a parking boy, and an unrecognized ticket in any parking lots, when fetch the car, then throw "Unrecognized parking ticket".
Given two parking lots, a parking boy, and a used ticket in any one of the parking lots, when fetch the car, then and throw "Unrecognized parking ticket".
Given two full parking lots, a parking boy, and a car, when park the car, then throw "No available position".

Story 5
Given two empty parking lots, a smart parking boy, and a car, when park the car, then return a parking ticket.
Given first full parking lot and second parking lot with available positions, a smart parking boy, and a car, when park the car, then return a parking ticket from second parking lot.
Given first parking lot with 1 empty position, capacity 5, and second parking lot with 2 empty positions, capacity 3, a smart parking boy, and a car, when park the car, then return a parking ticket from second parking lot.
Given two parking lots with a parked car each, a smart parking boy, two cars, and two tickets, when fetch the car twice, then return corresponding cars.
Given two parking lots, a smart parking boy, and an unrecognized ticket in any parking lots, when fetch the car, then throw "Unrecognized parking ticket".
Given two parking lots, a smart parking boy, and a used ticket in any one of the parking lots, when fetch the car, then and throw "Unrecognized parking ticket".
Given two full parking lots, a smart parking boy, and a car, when park the car, then throw "No available position".
