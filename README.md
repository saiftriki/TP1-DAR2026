# TP1

## Activité 1

![act1.jpg](screenshots/act1.jpg)

## Activité 2
### 2)
![act2_2.jpg](screenshots/act2_2.jpg)

Le client reçoit 251 au lieu de -5 parce que la communication ne peut transporter qu'un petit nombre (entre 0 et 255), donc -1 est transformé en 255 avant d'arriver au serveur. Le résultat 1275 est trop grand pour passer aussi, alors il est coupé et devient 251 ; il faut donc utiliser une méthode qui envoie l'entier en entier (`writeInt`/`readInt`).

### 4) Exploiter les deux classes DataInputStream et DataOutputStream:
![act2_4.jpg](screenshots/act2_4.jpg)

### 5) Échange de plusieurs entiers successivement:
![act2_5.jpg](screenshots/act2_5.jpg)