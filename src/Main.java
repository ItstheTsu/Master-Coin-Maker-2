import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bem-vindo ao Coin Master Make 2! Digite 'start' para começar.");

        double coins = 0;
        double itens = 0;
        double damagePlayer = 5;
        double xpGanho = 1;

        int level = 1;
        double constXp = 20;
        double BossLife = 120;
        double hpNPC = random.nextInt(15) + 1;

        String start = scanner.next();

        if (start.equals("start")) {
            while (level < 10) {
                System.out.println("Um Mob spawnou com " + hpNPC + " de HP.");
                System.out.println(" ");
                System.out.println("Você está no nível " + level);
                System.out.println("Escolha uma ação: ");
                System.out.println("1. Atacar");
                System.out.println("2. Correr");
                System.out.println("3. Inventário");

                int escolha = scanner.nextInt();

                if (escolha == 1 && level < 10) {

                    coins += random.nextInt(10);
                    itens += random.nextInt(5);
                    damagePlayer += random.nextInt(3);
                    double danoCausado = (int)damagePlayer;
                    hpNPC -= danoCausado;

                    while (hpNPC >= 1 && level < 9) {
                        xpGanho = random.nextInt(level * 10) + 1;
                        constXp -= xpGanho;

                        System.out.println("O mob continua vivo com, " + (int)hpNPC + " de HP, continue a batalha.");
                        System.out.println("Escolha uma ação: ");
                        System.out.println("1. Atacar");
                        System.out.println("2. Correr");
                        System.out.println("3. Inventário");
                        int battleChoose = scanner.nextInt();

                        if (battleChoose == 1) {
                            System.out.println(" ");
                            System.out.println("Você causou " + (int)danoCausado + " de dano.");
                            hpNPC -= danoCausado;
                        } if (battleChoose == 2) {
                            System.out.println("Você correu do combate. Não ganhou nada!");
                        } else if (battleChoose == 3) {
                            System.out.println("Inventário:");
                            System.out.println(" ");
                            System.out.println("Dano: " + (int)damagePlayer);
                            System.out.println(" ");
                            System.out.println("Artefatos: " + (int)itens);
                            System.out.println("Moedas: " + (int)coins);
                            System.out.println(" ");
                        }
                    }

                    if (hpNPC <= 0) {
                        System.out.println("Você derrotou o Monstro! Você ganhou " + (int)xpGanho + " de XP e " + (int)coins + " moedas.");
                        hpNPC = random.nextInt(20) + 1;
                        coins += random.nextInt(10);
                        itens += random.nextInt(5);
                        constXp -= xpGanho;
                    }

                    if (constXp <= 0) {
                        level++;
                        constXp += 20;
                        damagePlayer += random.nextInt(3);
                        System.out.println(" ");
                        System.out.println("Parabéns! Você subiu para o nível " + level + ".");
                        System.out.println(" ");
                        System.out.println("Você possui " + (int) coins + " moedas e " + (int) itens + " artefatos.");
                        System.out.println(" ");
                    }

                    if (itens >= 35) {
                        System.out.println("Você tem " + (int) itens + " artefatos no seu inventário, gostaria de usá-los?");
                        System.out.println("1. Consumir artefatos");
                        System.out.println("2. Prosseguir sem usá-los");

                        int escolhaArtefato = scanner.nextInt();

                        if (escolhaArtefato == 1) {
                            int danoArtefatos = random.nextInt(10) + 1;
                            damagePlayer += danoArtefatos;
                            itens = 0;
                            System.out.println("Você consumiu seus artefatos. Seu dano foi aumentado em " + danoArtefatos + ".");
                        }
                    }

                    if (level == 9) {
                        System.out.println("Você está no nível " + level + " atualmente. Você poderá escolher enfrentar o Boss inicial ou não!");
                        System.out.println("Escolha uma ação: ");
                        System.out.println("1. Atacar o Boss final!");
                        System.out.println("2. Se juntar ao Boss!");

                        int finalBoss = scanner.nextInt();

                        if (finalBoss == 1) {
                            System.out.println("Você escolheu enfrentar o Boss inicial, prepare-se!");
                            System.out.println("Você está no nível " + level + " atualmente, deseja consumir o poder dos deuses para continuar?!");
                            System.out.println("1. Sim!");
                            System.out.println("2. Não...");

                            int godnessChose = scanner.nextInt();

                            if (godnessChose == 1) {
                                System.out.println("Você está batalhando contra o Deus Demonio Caido, lute!");
                                System.out.println("A vida do Boss é de " + BossLife + " de HP.");

                                while (BossLife >= 1) {
                                    xpGanho = random.nextInt(level * 10) + 1;
                                    constXp -= xpGanho;

                                    System.out.println("O Boss continua vivo com, " + (int)BossLife + " de HP, continue a batalha.");
                                    System.out.println("Escolha uma ação: ");
                                    System.out.println("1. Atacar");
                                    System.out.println("2. Correr");
                                    System.out.println("3. Inventário");
                                    int battleChoose = scanner.nextInt();

                                    if (battleChoose == 1) {
                                        System.out.println("Você causou " + (int)danoCausado + " de dano.");
                                        BossLife -= danoCausado;
                                    } else if (battleChoose == 3) {
                                        System.out.println("Inventário:");
                                        System.out.println(" ");
                                        System.out.println("Dano: " + (int)damagePlayer);
                                        System.out.println(" ");
                                        System.out.println("Artefatos: " + (int)itens);
                                        System.out.println("Moedas: " + (int)coins);
                                        System.out.println(" ");
                                    }
                                } if (BossLife <= 0 ) {
                                    System.out.println("Você derrotou o Deus Demônio Caído! Você se tornou o Herói salvador!");
                                }

                            } else if (godnessChose == 2) {
                                System.out.println("Você escolheu não receber a benção dos Deuses, enfrente o mal com sua própria força!");

                                while (BossLife >= 1) {
                                    xpGanho = random.nextInt(level * 10) + 1;
                                    constXp -= xpGanho;

                                    System.out.println("O Boss continua vivo com, " + (int)BossLife + " de HP, continue a batalha.");
                                    System.out.println("Escolha uma ação: ");
                                    System.out.println("1. Atacar");
                                    System.out.println("2. Correr");
                                    System.out.println("3. Inventário");
                                    int battleChoose = scanner.nextInt();

                                    if (battleChoose == 1) {
                                        System.out.println("Você causou " + (int)danoCausado + " de dano.");
                                        BossLife -= danoCausado;
                                    } else if (battleChoose == 3) {
                                        System.out.println("Inventário:");
                                        System.out.println(" ");
                                        System.out.println("Dano: " + (int)damagePlayer);
                                        System.out.println(" ");
                                        System.out.println("Artefatos: " + (int)itens);
                                        System.out.println("Moedas: " + (int)coins);
                                        System.out.println(" ");
                                    }

                                } if (BossLife <= 0 ) {
                                    System.out.println("Você derrotou o Deus Demônio Caído! Você se tornou o Herói salvador!");
                                    constXp -= xpGanho;
                                }
                            }
                        } else if (finalBoss == 2) {
                            System.out.println("Você escolheu se juntar ao Boss final, prepare-se para destruir o mundo!");
                        }
                    }

                } else if (escolha == 2) {
                    System.out.println("Você correu do combate. Não ganhou nada!");
                } else if (escolha == 3) {
                    System.out.println("Inventário:");
                    System.out.println(" ");
                    System.out.println("Dano: " + (int)damagePlayer);
                    System.out.println(" ");
                    System.out.println("Artefatos: " + (int)itens);
                    System.out.println("Moedas: " + (int)coins);
                    System.out.println(" ");
                } else {
                    System.out.println("Escolha inválida. Tente novamente.");
                }
            }

            System.out.println("Você atingiu o nível máximo! O jogo acabou.");
            System.out.println("Moedas: " + (int) coins);
            System.out.println("Itens: " + (int) itens);
        } else {
            System.out.println("Comando inválido. O jogo não começou.");
        }

        scanner.close();
    }
}
