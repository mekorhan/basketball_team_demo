# basketball_team_demo

Project uses 8000 port

http://localhost:8000/graphiql and http://localhost:8000/graphql hosts can be use.

Example Requests:

Delete player:
  query:
    mutation{
      deletePlayer(id : 1)
    }
  variables:
    {
      "id": 
        {
          "id":8
        }
    }

Add player:
  query:
    mutation addPlayer($PlayerInput: PlayerInput) {
      addPlayer(playerInput: $PlayerInput) {
       name
       surname
       position
     }
    }
  variables:
    {
        "PlayerInput": {
            "name":"enes",
            "surname":"korhan",
            "position":"PG"
        }
    }
    
Get All Players:
  {
    players {
      id
      name
      surname
      position
    }
  }
