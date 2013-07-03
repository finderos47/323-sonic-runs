------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Sonic Runs
PURPOSE OF PROJECT: 
                    Avance: imagenes del jugador, imagen de un obstaculo(roca), 
                            realizar algunos movimientos del jugador.

VERSION or DATE: 25 06 2013
HOW TO START THIS PROJECT:
AUTHORS: Angel Isai Zavala Cano
USER INSTRUCTIONS: Solo corre y salta, sin que el obstaculo quite vidas al jugador.


PROJECT TITLE: Sonic Runs
PURPOSE OF PROJECT: 
                    Avance: 
                            He insertado las vidas.
                            Si un obstaculo toca al jugador resta vidas, 
                            Si las vidas llegan a 0 entonces el jugador 
                            pierde y muestra un letrero Game Over y se 
                            detenga el juego.
                            
                            Reutilize la clase "Mensaje" de POO Verano para
                            el mensaje.
                            
                            Realize una clase "Lives" para ir contando cuantas
                            vidas tiene el jugador.
                            
                            Realizar una clase "Bonus" que servira para darle 
                            fuerza de salto al jugador.                           
                            
                            
VERSION or DATE: 26 06 2013
HOW TO START THIS PROJECT:
AUTHORS: Angel Isai Zavala Cano
USER INSTRUCTIONS: Ya quitan vidas las piedas, es un movimiento repetitivo.

Fecha: 27/06/2013
                    Avance: 
                            Importe la clase "GiftImage" y "Counter" para imagenes y
                            contadores(vidas,fuerza de salto, distancia) respectivamente.
                            
                            Replazar el contador de vidas que tenia el juego por uno
                            de la clase "Counter" y realizar lo mismo que antes.
                            
                            Realize el contador de fuerza de salto, y que este incremente
                            si es que ha tocado a un "Bonus".
                            
                            Realize un contador de distancia, falta el scroll.
                            
                            Si no se presiona tecla el jugador cambia de imagen.
                            
                            Si se presiona tecla izquierda cambia de imagen (Gif).
                            
                            Realize que la clase "Obstacle" heredara a "Wall" y "Rock" la
                            propiedad de size, y el metodo de "leftLives()".
                            
                            Realize polimorfismo a los obstaculos.
                            
                            Realize que la clase "Elemento" heredara a "Player" y a "Enemy"
                            las propiedades como fuerza de salto, si esta saltando, aceleracion,
                            y algunos metodos para realizar el salto, cambiar la fuerza de salto
                            entre otras.
                            
Fecha: 28/06/2013
                    Avance:
                            Implemente el scroll en el mundo.
                            
                            Arreglar algunos problemas con las imagenes del jugador
                            y con las del bonus.
                            
                            Que se muevan los objetos juntamente con el escenario
                            
                            Tener una velocidad de Scroll horizontal
                            
                            Tener una barrera como obstaculo
Fecha: 29/06/2013
                    Avance: 
                            Trabaje en los bonus que aparecieran a cierta distancia en el
                            mundo, y que aumentara la fuerza de salto del jugador y que 
                            desaparecieran del juego una vez tocados por el jugador.
                            
                            Ponerle al mundo a la variable de instancia floor un valor del suelo.
                            
Fecha: 30/06/2013
                   Avance:
                            En que desaparecieran los bonus cuando salieran del juego.
                            
                            En que decrementara la velocidad cuando esta hacia la izquierda.
                            
                            Cambiar la imagen del jugador cuando salta.
                            
                            Poner objetos en el mundo para crear un nivel.
                            
                            He solucionado algunos problemas en cuanto a la logica.
                            
Fecha: 01/07/2013
                   Avance:
                            Poner un segundo nivel junto con una imagen diferente al primer nivel.
                            
                            Poner unos obstaculos/bonus por el camino.
                            
                            Poner a la mitad del nivel a un cierto enemigo.
                            
                            Limitar la velocidad de scroll y no ir mas alla de 30.
                            
                            Realizar el nivel 2.
                            
                            Poner vidas en el escenario.
                            
Fecha: 02/07/2013
                   Avance:
                            Poner el menu de inicio.
                            
                            Arregle el scroll del mundo para que no vaya tan rapido y se mareen.
                            
                            Un nuevo obstaculo tipo barril
                            
                            Corregir errores cuando terminaba el juego.