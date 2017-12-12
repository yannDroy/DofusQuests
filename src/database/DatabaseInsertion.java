package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Creation of the database
 * @author yann
 *
 */
public class DatabaseInsertion {

	/** Instance */
	private static DatabaseInsertion instance = new DatabaseInsertion();

	/** Database instance */
	private static DatabaseInstance database;

	/** Rows insertion counting */
	private static int rows;

	/**
	 * Database insertion constructor
	 */
	private DatabaseInsertion() {
		database = DatabaseInstance.getInstance();
	}

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println("Inserting values in the database ...\n");

		rows = 0;

		if(insertValues() != 0){
			System.out.println("Error during rows insertion");
			System.exit(1);
		}

		if(rows == 1)
			System.out.println("Database filled (" + rows + " row inserted)!\n");
		else if(rows > 1)
			System.out.println("Database filled (" + rows + " rows inserted)!\n");
		else
			System.out.println("No rows inserted\n");
	}

	/**
	 * Insert values in the database
	 * @return 0 if success, 1 otherwise
	 */
	private static int insertValues() {
		// PLAYERS
		insertPlayer(0, "Texeira");
		insertPlayer(1, "Acht");
		insertPlayer(2, "Xik");
		insertPlayer(3, "Pixies");
		insertPlayer(4, "Infra-red");
		insertPlayer(5, "Reanimation");
		insertPlayer(6, "Xkiwi");
		insertPlayer(7, "Endlessly");
		insertPlayer(8, "Marikaa");
		insertPlayer(9, "Daphairos");
		insertPlayer(10, "Thusia");
		insertPlayer(11, "Olixy");

		// SUCCESSES
		if(insertAchievement("SUC-01", "Général", null) != 0) return 1;
		if(insertAchievement("SUC-02", "Exploration", null) != 0) return 1;
		if(insertAchievement("SUC-03", "Donjons", null) != 0) return 1;
		if(insertAchievement("SUC-04", "Monstres", null) != 0) return 1;
		if(insertAchievement("SUC-05", "Quêtes", null) != 0) return 1;
		if(insertAchievement("SUC-06", "Métiers", null) != 0) return 1;
		if(insertAchievement("SUC-07", "Élevage", null) != 0) return 1;
		if(insertAchievement("SUC-08", "Événements", null) != 0) return 1;

		// GENERAL
		if(insertAchievement("SUB-001", "Général", "SUC-01")  != 0) return 1;
		if(insertAchievement("CHA-001", "Débutant (niveau 10)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-002", "Novice (niveau 20)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-003", "Initié (niveau 40)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-004", "Poussin (niveau 60)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-005", "Benjamin (niveau 80)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-006", "Minime (niveau 100)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-007", "Cadet (niveau 120)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-008", "Junior (niveau 140)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-009", "Espoir (niveau 160)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-010", "Senior (niveau 180)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-011", "Vétéran (niveau 200)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-012", "Une petite renommée (500 points)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-013", "Un peu de compagnie (1000 points)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-014", "Élite des bacs à sable (1337 points)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-015", "On commence à vous respecter (4000 points)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-016", "Un ami d''un ami a parlé de vous (6000 points)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-017", "<html>Vous montrez la Lune, ils regardent<br/>le doigt (8000 points)</html>", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-018", "Vous. Et les autres (10000 points)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-019", "Sans, labeur, larmes, sueur (12000 points)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-020", "Un nouvel espoir (14000 points)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-021", "C''est à moi que tu parles ? (16000 points)", "SUB-001")  != 0) return 1;
		if(insertAchievement("CHA-022", "Enutrosor", "SUB-001")  != 0) return 1;
		if(insertAchievement("QUE-0001", "La cité d''or (succès Exploration)", "CHA-022")  != 0) return 1;
		if(insertAchievement("QUE-0002", "La ruée vers l''or (succès Monstres)", "CHA-022")  != 0) return 1;
		if(insertAchievement("QUE-0003", "Rompre Malléfisk (succès Malléfisk)", "CHA-022")  != 0) return 1;
		if(insertAchievement("QUE-0004", "Le musée des Phorreurs (succès Phossile)", "CHA-022")  != 0) return 1;
		if(insertAchievement("QUE-0005", "Votre Seniorie (succès Roi Nidas)", "CHA-022")  != 0) return 1;
		if(insertAchievement("QUE-0006", "Le pays des Vermeils (succès Quêtes)", "CHA-022")  != 0) return 1;
		if(insertAchievement("CHA-023", "Srambad", "SUB-001")  != 0) return 1;
		if(insertAchievement("QUE-0006a", "La cité des voleurs (succès Exploration)", "CHA-023")  != 0) return 1;
		if(insertAchievement("QUE-0007", "Malfracturés (succès Monstres)", "CHA-023")  != 0) return 1;
		if(insertAchievement("QUE-0008", "Grand Ekarlatte (succès Capitaine Ekarlatte)", "CHA-023")  != 0) return 1;
		if(insertAchievement("QUE-0009", "Désintoxoliathisation (succès Toxoliath)", "CHA-023")  != 0) return 1;
		if(insertAchievement("QUE-0010", "Voligarchie (succès Reine des voleurs)", "CHA-023")  != 0) return 1;
		if(insertAchievement("QUE-0011", "Le royaume des ombres (succès Quêtes)", "CHA-023")  != 0) return 1;
		if(insertAchievement("CHA-024", "Xélorium", "SUB-001")  != 0) return 1;
		if(insertAchievement("QUE-0012", "Sa place est dans un musée (succès Exploration)", "CHA-024")  != 0) return 1;
		if(insertAchievement("QUE-0013", "Passer le temps (succès Monstres)", "CHA-024")  != 0) return 1;
		if(insertAchievement("QUE-0014", "Un passé trouble (succès Fraktale)", "CHA-024")  != 0) return 1;
		if(insertAchievement("QUE-0015", "Six fois neuf (succès XLII)", "CHA-024")  != 0) return 1;
		if(insertAchievement("QUE-0016", "Vortexicomane (succès Vortex)", "CHA-024")  != 0) return 1;
		if(insertAchievement("QUE-0017", "Le domaine des possibles (succès Quêtes)", "CHA-024")  != 0) return 1;
		if(insertAchievement("CHA-025", "Ecaflipus", "SUB-001")  != 0) return 1;
		if(insertAchievement("QUE-0018", "Un sacré terrain de jeu (succès Exploration)", "CHA-025")  != 0) return 1;
		if(insertAchievement("QUE-0019", "De simples pions (succès Monstres)", "CHA-025")  != 0) return 1;
		if(insertAchievement("QUE-0020", "Tâter le pou (succès Pounicheur)", "CHA-025")  != 0) return 1;
		if(insertAchievement("QUE-0021", "Faire l''autre Ush (succès Ush Galesh)", "CHA-025")  != 0) return 1;
		if(insertAchievement("QUE-0022", "Le défibrillateur (succès Chaloeil)", "CHA-025")  != 0) return 1;
		if(insertAchievement("QUE-0023", "Une contrée du hasard (succès Quêtes)", "CHA-025")  != 0) return 1;
		if(insertAchievement("CHA-026", "Nouvelle vague", "SUB-001")  != 0) return 1;
		if(insertAchievement("QUE-0024", "Aquariuuuum (succès Exploration)", "CHA-026")  != 0) return 1;
		if(insertAchievement("QUE-0025", "J''tape dans l''fond (succès Monstres)", "CHA-026")  != 0) return 1;
		if(insertAchievement("QUE-0026", "Mobilis in Mobili (succès Capitaine Meno)", "CHA-026")  != 0) return 1;
		if(insertAchievement("QUE-0027", "Koutoulou R''lyugluglu fhtagn (succès Larve de Koutoulou)", "CHA-026")  != 0) return 1;
		if(insertAchievement("QUE-0028", "Sous l''océan (succès Dantinéa)", "CHA-026")  != 0) return 1;
		if(insertAchievement("QUE-0029", "Abysses (succès Quêtes)", "CHA-026")  != 0) return 1;
		if(insertAchievement("CHA-027", "Ça arrache", "SUB-001")  != 0) return 1;
		if(insertAchievement("QUE-0030", "La traversée du désert (succès Exploration)", "CHA-027")  != 0) return 1;
		if(insertAchievement("QUE-0031", "Tempête de sable (succès Monstres)", "CHA-027")  != 0) return 1;
		if(insertAchievement("QUE-0032", "Fromage ou désert (succès Mansticore)", "CHA-027")  != 0) return 1;
		if(insertAchievement("QUE-0033", "Caramba (succès El Piko)", "CHA-027")  != 0) return 1;
		if(insertAchievement("QUE-0034", "Le chant des dunes (succès Père Ver)", "CHA-027")  != 0) return 1;
		if(insertAchievement("QUE-0035", "La reinde des damnés (succès Tal Kasha)", "CHA-027")  != 0) return 1;
		if(insertAchievement("QUE-0036", "Le marchand de sable est passé (succès Quêtes)", "CHA-027")  != 0) return 1;
		if(insertAchievement("CHA-028", "Sur le bout de la lande", "SUB-001")  != 0) return 1;
		if(insertAchievement("QUE-0037", "Promenade lugubre (succès Exploration)", "CHA-028")  != 0) return 1;
		if(insertAchievement("QUE-0038", "Entre chien et loup (succès Monstres)", "CHA-028")  != 0) return 1;
		if(insertAchievement("QUE-0039", "Sous le plus grand chapiteau du monde (succès Choudini)", "CHA-028")  != 0) return 1;
		if(insertAchievement("QUE-0040", "Bovidé enragé (succès Meulou)", "CHA-028")  != 0) return 1;
		if(insertAchievement("QUE-0041", "Bworker Texas Ranger (succès Bworker)", "CHA-028")  != 0) return 1;
		if(insertAchievement("QUE-0042", "Rase les goules (succès Anerice la Schushess)", "CHA-028")  != 0) return 1;
		if(insertAchievement("QUE-0043", "Fongicide (succès Ougah)", "CHA-028")  != 0) return 1;
		if(insertAchievement("QUE-0044", "Sidimotivé (succès Quêtes)", "CHA-028")  != 0) return 1;

		// EXPLORATION
		if(insertAchievement("SUB-002", "Général", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-029", "Les voyages déforment la jeunesse", "SUB-002") != 0) return 1;
		if(insertAchievement("SUB-003", "Incarnam", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-030", "Dans les nuages", "SUB-003") != 0) return 1;
		if(insertAchievement("QUE-0045", "Lac", "CHA-030") != 0) return 1;
		if(insertAchievement("QUE-0046", "Champs", "CHA-030") != 0) return 1;
		if(insertAchievement("QUE-0047", "Cimetière", "CHA-030") != 0) return 1;
		if(insertAchievement("QUE-0048", "Forêt", "CHA-030") != 0) return 1;
		if(insertAchievement("QUE-0049", "Mine", "CHA-030") != 0) return 1;
		if(insertAchievement("QUE-0050", "Pâturages", "CHA-030") != 0) return 1;
		if(insertAchievement("QUE-0051", "Route des âmes", "CHA-030") != 0) return 1;
		if(insertAchievement("QUE-0052", "Taverne", "CHA-030") != 0) return 1;
		if(insertAchievement("QUE-0053", "Temple Céleste", "CHA-030") != 0) return 1;
		if(insertAchievement("SUB-004", "Astrub", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-031", "Terre des novices, terre de nos vices", "SUB-004") != 0) return 1;
		if(insertAchievement("QUE-0054", "Calanques d''Astrub", "CHA-031") != 0) return 1;
		if(insertAchievement("QUE-0055", "Champs d''Astrub", "CHA-031") != 0) return 1;
		if(insertAchievement("QUE-0056", "Cité d''Astrub", "CHA-031") != 0) return 1;
		if(insertAchievement("QUE-0057", "Contour d''Astrub", "CHA-031") != 0) return 1;
		if(insertAchievement("QUE-0058", "Élevage de Bouftous du Château d''Amakna", "CHA-031") != 0) return 1;
		if(insertAchievement("QUE-0059", "Exploitation minière d''Astrub", "CHA-031") != 0) return 1;
		if(insertAchievement("QUE-0061", "Forêt d''Astrub", "CHA-031") != 0) return 1;
		if(insertAchievement("QUE-0062", "Coin des Tofus", "CHA-031") != 0) return 1;
		if(insertAchievement("QUE-0063", "Prairies d''Astrub", "CHA-031") != 0) return 1;
		if(insertAchievement("QUE-0064", "Souterrains d''Astrub", "CHA-031") != 0) return 1;
		if(insertAchievement("QUE-0065", "Souterrains profonds d''Astrub", "CHA-031") != 0) return 1;
		if(insertAchievement("SUB-005", "Amakna", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-032", "Voyage, voyage", "SUB-005") != 0) return 1;
		if(insertAchievement("QUE-0066", "Promenons-nous dans les bois", "CHA-032") != 0) return 1;
		if(insertAchievement("SBQ-0001", "Bord de la forêt maléfique", "QUE-0066") != 0) return 1;
		if(insertAchievement("SBQ-0002", "Clairière de Brouce Boulgour", "QUE-0066") != 0) return 1;
		if(insertAchievement("SBQ-0003", "Forêt d''Amakna", "QUE-0066") != 0) return 1;
		if(insertAchievement("SBQ-0004", "Forêt Maléfique", "QUE-0066") != 0) return 1;
		if(insertAchievement("SBQ-0005", "Millifutaie", "QUE-0066") != 0) return 1;
		if(insertAchievement("SBQ-0006", "Orée de la forêt des Abraknydes", "QUE-0066") != 0) return 1;
		if(insertAchievement("SBQ-0007", "Bois des Arak-haï", "QUE-0066") != 0) return 1;
		if(insertAchievement("SBQ-0008", "Forêt Sombre", "QUE-0066") != 0) return 1;
		if(insertAchievement("QUE-0067", "Je prends quelques oeufs et je repars", "CHA-032") != 0) return 1;
		if(insertAchievement("SBQ-0008a", "La presqu''île des Dragoeufs", "QUE-0067") != 0) return 1;
		if(insertAchievement("SBQ-0009", "Sanctuaire des Dragoeufs", "QUE-0067") != 0) return 1;
		if(insertAchievement("SBQ-0010", "Souterrains des Dragoeufs", "QUE-0067") != 0) return 1;
		if(insertAchievement("SBQ-0011", "Village des Dragoeufs", "QUE-0067") != 0) return 1;
		if(insertAchievement("QUE-0068", "Visite des autochtones", "CHA-032") != 0) return 1;
		if(insertAchievement("SBQ-0012", "Campement des Bworks", "QUE-0068") != 0) return 1;
		if(insertAchievement("SBQ-0013", "Campement des Gobelins", "QUE-0068") != 0) return 1;
		if(insertAchievement("SBQ-0014", "Montagne des Craqueleurs", "QUE-0068") != 0) return 1;
		if(insertAchievement("SBQ-0015", "Péninsule des gelées", "QUE-0068") != 0) return 1;
		if(insertAchievement("SBQ-0016", "Coin des Boos", "QUE-0068") != 0) return 1;
		if(insertAchievement("SBQ-0017", "Coin des Bouftous", "QUE-0068") != 0) return 1;
		if(insertAchievement("SBQ-0018", "Montagne basse des Craqueleurs", "QUE-0068") != 0) return 1;
		if(insertAchievement("SBQ-0019", "Plaine des Scarafeuilles", "QUE-0068") != 0) return 1;
		if(insertAchievement("SBQ-0020", "Territoire des Bandits", "QUE-0068") != 0) return 1;
		if(insertAchievement("SBQ-0021", "Territoire des Porcos", "QUE-0068") != 0) return 1;
		if(insertAchievement("SBQ-0022", "Village des Bworks", "QUE-0068") != 0) return 1;
		if(insertAchievement("QUE-0069", "Architecture locale", "CHA-032") != 0) return 1;
		if(insertAchievement("SBQ-0023", "Château d''Amakna", "QUE-0069") != 0) return 1;
		if(insertAchievement("SBQ-0024", "Cimetière", "QUE-0069") != 0) return 1;
		if(insertAchievement("SBQ-0025", "Village d''Amakna", "QUE-0069") != 0) return 1;
		if(insertAchievement("SBQ-0026", "Cryptes", "QUE-0069") != 0) return 1;
		if(insertAchievement("SBQ-0027", "Souterrains", "QUE-0069") != 0) return 1;
		if(insertAchievement("SBQ-0028", "Souterrains du Château d''Amakna", "QUE-0069") != 0) return 1;
		if(insertAchievement("SBQ-0029", "Prison", "QUE-0069") != 0) return 1;
		if(insertAchievement("SBQ-0030", "Berceau", "QUE-0069") != 0) return 1;
		if(insertAchievement("SBQ-0031", "Passage vers Brâkmar", "QUE-0069") != 0) return 1;
		if(insertAchievement("QUE-0070", "Les pieds dans l''eau", "CHA-032") != 0) return 1;
		if(insertAchievement("SBQ-0032", "Côte d''Asse", "QUE-0070") != 0) return 1;
		if(insertAchievement("SBQ-0033", "Marécage", "QUE-0070") != 0) return 1;
		if(insertAchievement("SBQ-0034", "Port de Madrestam", "QUE-0070") != 0) return 1;
		if(insertAchievement("SBQ-0035", "Rivage sufokien", "QUE-0070") != 0) return 1;
		if(insertAchievement("SBQ-0036", "Rivière Kawaii", "QUE-0070") != 0) return 1;
		if(insertAchievement("SBQ-0037", "Sufokia", "QUE-0070") != 0) return 1;
		if(insertAchievement("QUE-0071", "Douce campagne", "CHA-032") != 0) return 1;
		if(insertAchievement("SBQ-0038", "Campagne d''Amakna", "QUE-0071") != 0) return 1;
		if(insertAchievement("SBQ-0039", "Champ des Ingalsse", "QUE-0071") != 0) return 1;
		if(insertAchievement("SBQ-0040", "Champ du repos", "QUE-0071") != 0) return 1;
		if(insertAchievement("SUB-006", "Île d''Otomaï", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-033", "Voyage au centre de la tourbière", "SUB-006") != 0) return 1;
		if(insertAchievement("QUE-0071a", "Île des naufragés", "CHA-033") != 0) return 1;
		if(insertAchievement("QUE-0072", "Village côtier", "CHA-033") != 0) return 1;
		if(insertAchievement("QUE-0073", "Plage de Corail", "CHA-033") != 0) return 1;
		if(insertAchievement("QUE-0074", "Plaines herbeuses", "CHA-033") != 0) return 1;
		if(insertAchievement("QUE-0075", "Village des éleveurs", "CHA-033") != 0) return 1;
		if(insertAchievement("QUE-0076", "Tourbière nauséabonde", "CHA-033") != 0) return 1;
		if(insertAchievement("QUE-0077", "Arche d''Otomaï", "CHA-033") != 0) return 1;
		if(insertAchievement("QUE-0078", "Tourbière sans fond", "CHA-033") != 0) return 1;
		if(insertAchievement("QUE-0079", "Jungle obscure", "CHA-033") != 0) return 1;
		if(insertAchievement("QUE-0080", "Feuillage de l''arbre Hakam", "CHA-033") != 0) return 1;
		if(insertAchievement("QUE-0081", "Tronc de l''arbre Hakam", "CHA-033") != 0) return 1;
		if(insertAchievement("QUE-0082", "Village de la Canopée", "CHA-033") != 0) return 1;
		if(insertAchievement("SUB-007", "Île de Moon", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-034", "Sur la plage abandonnée...", "SUB-007") != 0) return 1;
		if(insertAchievement("QUE-0083", "Plage de la Tortue", "CHA-034") != 0) return 1;
		if(insertAchievement("QUE-0084", "Chemin du crâne", "CHA-034") != 0) return 1;
		if(insertAchievement("QUE-0085", "Jungle interdite", "CHA-034") != 0) return 1;
		if(insertAchievement("QUE-0086", "Forêt des Masques", "CHA-034") != 0) return 1;
		if(insertAchievement("SUB-008", "Île des Wabbits", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-035", "Les Cawottes sont cuites", "SUB-008") != 0) return 1;
		if(insertAchievement("QUE-0087", "Île de la Cawotte", "CHA-035") != 0) return 1;
		if(insertAchievement("QUE-0088", "Souterrains des Wabbits", "CHA-035") != 0) return 1;
		if(insertAchievement("QUE-0089", "Îlot de Waldo", "CHA-035") != 0) return 1;
		if(insertAchievement("QUE-0090", "Îlot des tombeaux", "CHA-035") != 0) return 1;
		if(insertAchievement("QUE-0091", "Îlot de la couronne", "CHA-035") != 0) return 1;
		if(insertAchievement("SUB-009", "Île du Minotoror", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-036", "Coquillages et crustacés...", "SUB-009") != 0) return 1;
		if(insertAchievement("QUE-0092", "Île du Minotoror", "CHA-036") != 0) return 1;
		if(insertAchievement("QUE-0093", "Labyrinthe du Minotoror", "CHA-036") != 0) return 1;
		if(insertAchievement("SUB-010", "Pandala", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-037", "Pandalade", "SUB-010") != 0) return 1;
		if(insertAchievement("QUE-0094", "Pont de Pandala", "CHA-037") != 0) return 1;
		if(insertAchievement("QUE-0095", "Village de Pandala", "CHA-037") != 0) return 1;
		if(insertAchievement("QUE-0096", "Faubourgs de Pandala", "CHA-037") != 0) return 1;
		if(insertAchievement("QUE-0097", "Village du Pichon Frétillant", "CHA-037") != 0) return 1;
		if(insertAchievement("QUE-0098", "Forêt de Pandala", "CHA-037") != 0) return 1;
		if(insertAchievement("QUE-0099", "Pandala neutre", "CHA-037") != 0) return 1;
		if(insertAchievement("QUE-0100", "Bordure d''Akwadala", "CHA-037") != 0) return 1;
		if(insertAchievement("QUE-0101", "Bordure de Terrdala", "CHA-037") != 0) return 1;
		if(insertAchievement("QUE-0102", "Bordure d''Aerdala", "CHA-037") != 0) return 1;
		if(insertAchievement("QUE-0103", "Bordure de Feudala", "CHA-037") != 0) return 1;
		if(insertAchievement("QUE-0104", "Pont de Grobe", "CHA-037") != 0) return 1;
		if(insertAchievement("QUE-0105", "Île de Grobe", "CHA-037") != 0) return 1;
		if(insertAchievement("SUB-011", "Bonta", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-038", "La cité blanche", "SUB-011") != 0) return 1;
		if(insertAchievement("QUE-0106", "Centre-ville", "CHA-038") != 0) return 1;
		if(insertAchievement("QUE-0107", "Fortification de Bonta", "CHA-038") != 0) return 1;
		if(insertAchievement("QUE-0108", "Pâturages de Bonta", "CHA-038") != 0) return 1;
		if(insertAchievement("QUE-0109", "Quartier des Alchimistes", "CHA-038") != 0) return 1;
		if(insertAchievement("QUE-0110", "Quartier des Bijoutiers", "CHA-038") != 0) return 1;
		if(insertAchievement("QUE-0111", "Quartier des Bouchers", "CHA-038") != 0) return 1;
		if(insertAchievement("QUE-0112", "Quartier des Boulangers", "CHA-038") != 0) return 1;
		if(insertAchievement("QUE-0113", "Quartier des Bricoleurs", "CHA-038") != 0) return 1;
		if(insertAchievement("QUE-0114", "Quartier des Bûcherons", "CHA-038") != 0) return 1;
		if(insertAchievement("QUE-0115", "Quartier des Forgerons", "CHA-038") != 0) return 1;
		if(insertAchievement("QUE-0116", "Quartier des Pêcheurs", "CHA-038") != 0) return 1;
		if(insertAchievement("QUE-0117", "Quartier des Tailleurs", "CHA-038") != 0) return 1;
		if(insertAchievement("QUE-0118", "Quartier des Éleveurs", "CHA-038") != 0) return 1;
		if(insertAchievement("QUE-0119", "Égouts de Bonta", "CHA-038") != 0) return 1;
		if(insertAchievement("QUE-0120", "Cimetière des Héros", "CHA-038") != 0) return 1;
		if(insertAchievement("SUB-012", "Cania", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-039", "Des cailloux partout", "SUB-012") != 0) return 1;
		if(insertAchievement("QUE-0140", "Baie de Cania", "CHA-039") != 0) return 1;
		if(insertAchievement("QUE-0141", "Bois de Litneg", "CHA-039") != 0) return 1;
		if(insertAchievement("QUE-0142", "Cirque de Cania", "CHA-039") != 0) return 1;
		if(insertAchievement("QUE-0143", "Dents de Pierre", "CHA-039") != 0) return 1;
		if(insertAchievement("QUE-0144", "Lac de Cania", "CHA-039") != 0) return 1;
		if(insertAchievement("QUE-0145", "Landes de Cania", "CHA-039") != 0) return 1;
		if(insertAchievement("QUE-0146", "Champs de Cania", "CHA-039") != 0) return 1;
		if(insertAchievement("QUE-0147", "Massif de Cania", "CHA-039") != 0) return 1;
		if(insertAchievement("QUE-0148", "Pics de Cania", "CHA-039") != 0) return 1;
		if(insertAchievement("QUE-0149", "Plaine des Porkass", "CHA-039") != 0) return 1;
		if(insertAchievement("QUE-0150", "Plaines Rocheuses", "CHA-039") != 0) return 1;
		if(insertAchievement("QUE-0151", "Pénates du Corbac", "CHA-039") != 0) return 1;
		if(insertAchievement("QUE-0152", "Routes Rocailleuses", "CHA-039") != 0) return 1;
		if(insertAchievement("SUB-013", "Brâkmar", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-040", "La cité de la peur", "SUB-013") != 0) return 1;
		if(insertAchievement("QUE-0153", "Bordure de Brâkmar", "CHA-040") != 0) return 1;
		if(insertAchievement("QUE-0154", "Centre-ville", "CHA-040") != 0) return 1;
		if(insertAchievement("QUE-0155", "Quartier des Alchimistes", "CHA-040") != 0) return 1;
		if(insertAchievement("QUE-0156", "Quartier des Bijoutiers", "CHA-040") != 0) return 1;
		if(insertAchievement("QUE-0157", "Quartier des Bouchers", "CHA-040") != 0) return 1;
		if(insertAchievement("QUE-0158", "Quartier des Boulangers", "CHA-040") != 0) return 1;
		if(insertAchievement("QUE-0159", "Quartier des Bricoleurs", "CHA-040") != 0) return 1;
		if(insertAchievement("QUE-0160", "Quartier des Bûcherons", "CHA-040") != 0) return 1;
		if(insertAchievement("QUE-0161", "Quartier des Forgerons", "CHA-040") != 0) return 1;
		if(insertAchievement("QUE-0162", "Quartier des Pêcheurs", "CHA-040") != 0) return 1;
		if(insertAchievement("QUE-0163", "Quartier des Tailleurs", "CHA-040") != 0) return 1;
		if(insertAchievement("QUE-0164", "Quartier des Éleveurs", "CHA-040") != 0) return 1;
		if(insertAchievement("QUE-0165", "Égouts de Brâkmar", "CHA-040") != 0) return 1;
		if(insertAchievement("QUE-0166", "Cimetière des Torturés", "CHA-040") != 0) return 1;
		if(insertAchievement("QUE-0167", "Haras de Brâkmar", "CHA-040") != 0) return 1;
		if(insertAchievement("SUB-014", "Sidimote", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-041", "Promenade lugubre", "SUB-014") != 0) return 1;
		if(insertAchievement("QUE-0168", "Désolation de Sidimote", "CHA-041") != 0) return 1;
		if(insertAchievement("QUE-0169", "Route des Roulottes", "CHA-041") != 0) return 1;
		if(insertAchievement("QUE-0170", "Terres Désacrées", "CHA-041") != 0) return 1;
		if(insertAchievement("QUE-0171", "Gisgoul", "CHA-041") != 0) return 1;
		if(insertAchievement("QUE-0172", "Hauts des Hurlements", "CHA-041") != 0) return 1;
		if(insertAchievement("QUE-0173", "Domaines des Fungus", "CHA-041") != 0) return 1;
		if(insertAchievement("QUE-0174", "Caverne des Fungus", "CHA-041") != 0) return 1;
		if(insertAchievement("SUB-015", "Montagne des Koalaks", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-042", "Tout ce chemin pour du Kaliptus", "SUB-015") != 0) return 1;
		if(insertAchievement("QUE-0175", "Village des Éleveurs", "CHA-042") != 0) return 1;
		if(insertAchievement("QUE-0176", "Territoire des Draodindes Sauvages", "CHA-042") != 0) return 1;
		if(insertAchievement("QUE-0177", "Lacs enchantés", "CHA-042") != 0) return 1;
		if(insertAchievement("QUE-0178", "Marécages nauséabonds", "CHA-042") != 0) return 1;
		if(insertAchievement("QUE-0179", "Marécages sans fond", "CHA-042") != 0) return 1;
		if(insertAchievement("QUE-0180", "Forêt de Kaliptus", "CHA-042") != 0) return 1;
		if(insertAchievement("QUE-0181", "Canyon sauvage", "CHA-042") != 0) return 1;
		if(insertAchievement("QUE-0182", "Cimetière primitif", "CHA-042") != 0) return 1;
		if(insertAchievement("QUE-0183", "Vallée de la Morh''Kitu", "CHA-042") != 0) return 1;
		if(insertAchievement("SUB-016", "Île de Sakaï", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-043", "Froid dans le dos", "SUB-016") != 0) return 1;
		if(insertAchievement("QUE-0184", "Port de Sakaï", "CHA-043") != 0) return 1;
		if(insertAchievement("QUE-0185", "Plainde de Sakaï", "CHA-043") != 0) return 1;
		if(insertAchievement("QUE-0186", "Forêt enneigée", "CHA-043") != 0) return 1;
		if(insertAchievement("SUB-017", "Frigost", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-044", "Sang froid", "SUB-017") != 0) return 1;
		if(insertAchievement("QUE-0187", "Mer Kantil", "CHA-044") != 0) return 1;
		if(insertAchievement("QUE-0188", "Port de givre", "CHA-044") != 0) return 1;
		if(insertAchievement("QUE-0189", "La Bourgade", "CHA-044") != 0) return 1;
		if(insertAchievement("QUE-0190", "Champs de glace", "CHA-044") != 0) return 1;
		if(insertAchievement("QUE-0191", "Lac gelé", "CHA-044") != 0) return 1;
		if(insertAchievement("QUE-0192", "Forêt des pains perdus", "CHA-044") != 0) return 1;
		if(insertAchievement("QUE-0193", "Berceau d''Alma", "CHA-044") != 0) return 1;
		if(insertAchievement("QUE-0194", "Larmes d''Ouronigride", "CHA-044") != 0) return 1;
		if(insertAchievement("QUE-0195", "Crevasse Perge", "CHA-044") != 0) return 1;
		if(insertAchievement("QUE-0196", "Village enseveli", "CHA-044") != 0) return 1;
		if(insertAchievement("QUE-0197", "Forêt pétrifiée", "CHA-044") != 0) return 1;
		if(insertAchievement("QUE-0198", "Crocs de verre", "CHA-044") != 0) return 1;
		if(insertAchievement("QUE-0199", "Grottes gelées", "CHA-044") != 0) return 1;
		if(insertAchievement("QUE-0200", "Mont Torrideau", "CHA-044") != 0) return 1;
		if(insertAchievement("QUE-0201", "Ruche des Gloursons", "CHA-044") != 0) return 1;
		if(insertAchievement("CHA-045", "Château de neige", "SUB-017") != 0) return 1;
		if(insertAchievement("QUE-0202", "Bastion des froides légions", "CHA-045") != 0) return 1;
		if(insertAchievement("QUE-0203", "Tannerie Écarlate", "CHA-045") != 0) return 1;
		if(insertAchievement("QUE-0204", "Remparts à vent", "CHA-045") != 0) return 1;
		if(insertAchievement("QUE-0205", "Jardins d''hiver", "CHA-045") != 0) return 1;
		if(insertAchievement("QUE-0206", "Pied de la Tour de la Clepsydre", "CHA-045") != 0) return 1;
		if(insertAchievement("QUE-0207", "Tour de la Clepsydre", "CHA-045") != 0) return 1;
		if(insertAchievement("CHA-046", "Roc des Salbatroces", "SUB-017") != 0) return 1;
		if(insertAchievement("SUB-018", "Dimensions", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-047", "La cité d''or", "SUB-018") != 0) return 1;
		if(insertAchievement("QUE-0208", "Creuset des fortunés", "CHA-047") != 0) return 1;
		if(insertAchievement("QUE-0209", "Carrière aurifère", "CHA-047") != 0) return 1;
		if(insertAchievement("QUE-0210", "Retraite des éternels", "CHA-047") != 0) return 1;
		if(insertAchievement("CHA-048", "La cité des voleurs", "SUB-018") != 0) return 1;
		if(insertAchievement("QUE-0211", "Ruelles des Eaux-Suaires", "CHA-048") != 0) return 1;
		if(insertAchievement("QUE-0212", "Catacombres", "CHA-048") != 0) return 1;
		if(insertAchievement("QUE-0213", "Hauts Ténébreux", "CHA-048") != 0) return 1;
		if(insertAchievement("CHA-049", "Sa place est dans un musée", "SUB-018") != 0) return 1;
		if(insertAchievement("QUE-0214", "Chemins d''hier", "CHA-049") != 0) return 1;
		if(insertAchievement("QUE-0215", "Jour présent", "CHA-049") != 0) return 1;
		if(insertAchievement("QUE-0216", "Lendemains incertains", "CHA-049") != 0) return 1;
		if(insertAchievement("CHA-050", "Un sacré terrain de jeu", "SUB-018") != 0) return 1;
		if(insertAchievement("QUE-0217", "Pierres de l''élévation", "CHA-050") != 0) return 1;
		if(insertAchievement("QUE-0218", "Lande Poilue", "CHA-050") != 0) return 1;
		if(insertAchievement("QUE-0219", "Temple de Kerubim", "CHA-050") != 0) return 1;
		if(insertAchievement("CHA-051", "Dimension obscure", "SUB-018") != 0) return 1;
		if(insertAchievement("SUB-019", "Profondeurs de Sufokia", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-052", "Aquariuuuum", "SUB-019") != 0) return 1;
		if(insertAchievement("QUE-0220", "Ville submergée", "CHA-052") != 0) return 1;
		if(insertAchievement("QUE-0221", "Ancienne Sufokia", "CHA-052") != 0) return 1;
		if(insertAchievement("QUE-0222", "Vestiges Engloutis", "CHA-052") != 0) return 1;
		if(insertAchievement("QUE-0223", "Domaine des Trithons", "CHA-052") != 0) return 1;
		if(insertAchievement("QUE-0224", "Faille des Trithons", "CHA-052") != 0) return 1;
		if(insertAchievement("QUE-0225", "Tréfonds des Trithons", "CHA-052") != 0) return 1;
		if(insertAchievement("QUE-0226", "Plateau de R''lyugluglu", "CHA-052") != 0) return 1;
		if(insertAchievement("QUE-0227", "Fosse de R''lyugluglu", "CHA-052") != 0) return 1;
		if(insertAchievement("QUE-0228", "Abîme de R''lyugluglu", "CHA-052") != 0) return 1;
		if(insertAchievement("QUE-0229", "Salle des Embruns", "CHA-052") != 0) return 1;
		if(insertAchievement("QUE-0230", "Salle des Courants", "CHA-052") != 0) return 1;
		if(insertAchievement("QUE-0231", "Salle des Abîmes", "CHA-052") != 0) return 1;
		if(insertAchievement("SUB-020", "Saharach", "SUC-02") != 0) return 1;
		if(insertAchievement("CHA-053", "La traversée du désert", "SUB-020") != 0) return 1;
		if(insertAchievement("QUE-0233", "Port de Sarakech", "CHA-053") != 0) return 1;
		if(insertAchievement("QUE-0234", "Dunes des ossements", "CHA-053") != 0) return 1;
		if(insertAchievement("QUE-0235", "Territoire Cacterre", "CHA-053") != 0) return 1;
		if(insertAchievement("QUE-0236", "Gorges des Vents Hurlants", "CHA-053") != 0) return 1;
		if(insertAchievement("QUE-0237", "Cité oubliée", "CHA-053") != 0) return 1;
		if(insertAchievement("QUE-0238", "Pyramide Maudite", "CHA-053") != 0) return 1;
		
		// DONJONS
		if(insertAchievement("SUB-021", "Général", "SUC-03") != 0) return 1;
		if(insertAchievement("CHA-054", "En fermant les yeux (10 challenges)", "SUB-021") != 0) return 1;
		if(insertAchievement("CHA-055", "Vigilant (100 challenges)", "SUB-021") != 0) return 1;
		if(insertAchievement("CHA-056", "Mission impossible (succès Donjon)", "SUB-021") != 0) return 1;
		if(insertAchievement("CHA-057", "Mission impossible II (succès Idole)", "SUB-021") != 0) return 1;
		if(insertAchievement("SUB-022", "Niveaux 1 à 50", "SUC-03") != 0) return 1;
		if(insertAchievement("CHA-058", "<html>Les grandes choses ont de petits commencements<br/>(succès finir Donjon)</html>", "SUB-022") != 0) return 1;
		if(insertAchievement("QUE-0239", "Crypte de Kardorim", "CHA-058") != 0) return 1;
		if(insertAchievement("QUE-0240", "Donjons des champs", "CHA-058") != 0) return 1;
		if(insertAchievement("QUE-0241", "Donjon Ensablé", "CHA-058") != 0) return 1;
		if(insertAchievement("QUE-0242", "Donjon des Bouftous", "CHA-058") != 0) return 1;
		if(insertAchievement("QUE-0243", "Donjon des Scarafeuilles", "CHA-058") != 0) return 1;
		if(insertAchievement("QUE-0244", "Donjon des Tofus", "CHA-058") != 0) return 1;
		if(insertAchievement("QUE-0245", "Mission Fantôme", "CHA-058") != 0) return 1;
		if(insertAchievement("QUE-0246", "Donjon des Squelettes", "CHA-058") != 0) return 1;
		if(insertAchievement("QUE-0247", "Cache de Kankreblath", "CHA-058") != 0) return 1;
		if(insertAchievement("QUE-0248", "Donjon des Bworks", "CHA-058") != 0) return 1;
		if(insertAchievement("QUE-0249", "Donjon des Forgerons", "CHA-058") != 0) return 1;
		if(insertAchievement("QUE-0250", "Donjon des Larves", "CHA-058") != 0) return 1;
		if(insertAchievement("QUE-0251", "Grotte Hesque", "CHA-058") != 0) return 1;
		if(insertAchievement("QUE-0252", "Nid du Kwakwa", "CHA-058") != 0) return 1;
		if(insertAchievement("QUE-0253", "Caverne des Bulbes", "CHA-058") != 0) return 1;
		if(insertAchievement("CHA-059", "Les petits d''abord (succès Donjon)", "SUB-022") != 0) return 1;
		if(insertAchievement("QUE-0254", "Quelques poils au menton", "CHA-059") != 0) return 1;
		if(insertAchievement("SBQ-0041", "Kardorim (Zombie)", "QUE-0254") != 0) return 1;
		if(insertAchievement("SBQ-0042", "Kardorim (Premier)", "QUE-0254") != 0) return 1;
		if(insertAchievement("SBQ-0043", "Kardorim (Duo)", "QUE-0254") != 0) return 1;
		if(insertAchievement("QUE-0255", "Un petit coup de faux en passant", "CHA-059") != 0) return 1;
		if(insertAchievement("SBQ-0044", "Tournesol Affamé (Collant)", "QUE-0255") != 0) return 1;
		if(insertAchievement("SBQ-0045", "Tournesol Affamé (Premier)", "QUE-0255") != 0) return 1;
		if(insertAchievement("SBQ-0046", "Tournesol Affamé (Duo)", "QUE-0255") != 0) return 1;
		if(insertAchievement("QUE-0256", "J''écrase ton château de sable.", "CHA-059") != 0) return 1;
		if(insertAchievement("SBQ-0047", "Mob l''Éponge (Anachorète)", "QUE-0256") != 0) return 1;
		if(insertAchievement("SBQ-0048", "Mob l''Éponge (Versatile)", "QUE-0256") != 0) return 1;
		if(insertAchievement("SBQ-0049", "Mob l''Éponge (Duo)", "QUE-0256") != 0) return 1;
		if(insertAchievement("QUE-0257", "Ceux qui bavent méritent de trépasser", "CHA-059") != 0) return 1;
		if(insertAchievement("SBQ-0050", "Bouftou Royal (Pusillanime)", "QUE-0257") != 0) return 1;
		if(insertAchievement("SBQ-0051", "Bouftou Royal (Blitzkrieg)", "QUE-0257") != 0) return 1;
		if(insertAchievement("SBQ-0052", "Bouftou Royal (Duo)", "QUE-0257") != 0) return 1;
		if(insertAchievement("QUE-0258", "Effeuillage doré", "CHA-059") != 0) return 1;
		if(insertAchievement("SBQ-0053", "Scarabosse Doré (Zombie)", "QUE-0258") != 0) return 1;
		if(insertAchievement("SBQ-0054", "Scarabosse Doré (Mains propres)", "QUE-0258") != 0) return 1;
		if(insertAchievement("SBQ-0055", "Scarabosse Doré (Duo)", "QUE-0258") != 0) return 1;
		if(insertAchievement("QUE-0259", "Poids plume", "CHA-059") != 0) return 1;
		if(insertAchievement("SBQ-0056", "Batofu (Statue)", "QUE-0259") != 0) return 1;
		if(insertAchievement("SBQ-0057", "Batofu (Versatile)", "QUE-0259") != 0) return 1;
		if(insertAchievement("SBQ-0058", "Batofu (Duo)", "QUE-0259") != 0) return 1;
		if(insertAchievement("QUE-0260", "SOS Fantômes", "CHA-059") != 0) return 1;
		if(insertAchievement("SBQ-0059", "Boostache (Anachorète)", "QUE-0260") != 0) return 1;
		if(insertAchievement("SBQ-0060", "Boostache (Dernier)", "QUE-0260") != 0) return 1;
		if(insertAchievement("SBQ-0061", "Boostache (Duo)", "QUE-0260") != 0) return 1;
		if(insertAchievement("QUE-0261", "Ils n''ont pas fait de vieux os", "CHA-059") != 0) return 1;
		if(insertAchievement("SBQ-0062", "Chafer Ronin (Nomade)", "QUE-0261") != 0) return 1;
		if(insertAchievement("SBQ-0063", "Chafer Ronin (Premier)", "QUE-0261") != 0) return 1;
		if(insertAchievement("SBQ-0064", "Chafer Ronin (Duo)", "QUE-0261") != 0) return 1;
		if(insertAchievement("QUE-0262", "Vous n''êtes que des insectes", "CHA-059") != 0) return 1;
		if(insertAchievement("SBQ-0065", "Kankreblath (Collant)", "QUE-0262") != 0) return 1;
		if(insertAchievement("SBQ-0066", "Kankreblath (Dernier)", "QUE-0262") != 0) return 1;
		if(insertAchievement("SBQ-0067", "Kankreblath (Duo)", "QUE-0262") != 0) return 1;
		if(insertAchievement("QUE-0263", "Moâ écrabouiller toâ", "CHA-059") != 0) return 1;
		if(insertAchievement("SBQ-0068", "Bworkette (Anachorète)", "QUE-0263") != 0) return 1;
		if(insertAchievement("SBQ-0069", "Bworkette (Premier)", "QUE-0263") != 0) return 1;
		if(insertAchievement("SBQ-0070", "Bworkette (Duo)", "QUE-0263") != 0) return 1;
		if(insertAchievement("QUE-0264", "À bout de forges", "CHA-059") != 0) return 1;
		if(insertAchievement("SBQ-0071", "Coffre des Forgerons (Nomade)", "QUE-0264") != 0) return 1;
		if(insertAchievement("SBQ-0072", "Coffre des Forgerons (Premier)", "QUE-0264") != 0) return 1;
		if(insertAchievement("SBQ-0073", "Coffre des Forgerons (Duo)", "QUE-0264") != 0) return 1;
		if(insertAchievement("QUE-0265", "S''en larver les mains", "CHA-059") != 0) return 1;
		if(insertAchievement("SBQ-0074", "Shin Larve (Pusillanime)", "QUE-0265") != 0) return 1;
		if(insertAchievement("SBQ-0075", "Shin Larve (Vesatile)", "QUE-0265") != 0) return 1;
		if(insertAchievement("SBQ-0076", "Shin Larve (Duo)", "QUE-0265") != 0) return 1;
		if(insertAchievement("QUE-0266", "La grande barrière de Corailleur", "CHA-059") != 0) return 1;
		if(insertAchievement("SBQ-0077", "Corailleur Magistral (Hardi)", "QUE-0266") != 0) return 1;
		if(insertAchievement("SBQ-0078", "Corailleur Magistral (Blitzkrieg)", "QUE-0266") != 0) return 1;
		if(insertAchievement("SBQ-0079", "Corailleur Magistral (Duo)", "QUE-0266") != 0) return 1;
		if(insertAchievement("QUE-0267", "Nidification annulée", "CHA-059") != 0) return 1;
		if(insertAchievement("SBQ-0080", "Kwakwa (Zombie)", "QUE-0267") != 0) return 1;
		if(insertAchievement("SBQ-0081", "Kwakwa (Mains propres)", "QUE-0267") != 0) return 1;
		if(insertAchievement("SBQ-0082", "Kwakwa (Duo)", "QUE-0267") != 0) return 1;
		if(insertAchievement("QUE-0268", "Remous du bulbe", "CHA-059") != 0) return 1;
		if(insertAchievement("SBQ-0083", "Bulbig Brozeur (Anachorète)", "QUE-0268") != 0) return 1;
		if(insertAchievement("SBQ-0084", "Bulbig Brozeur (Mains propres)", "QUE-0268") != 0) return 1;
		if(insertAchievement("SBQ-0085", "Bulbig Brozeur (Duo)", "QUE-0268") != 0) return 1;
		if(insertAchievement("CHA-060", "L''aventurier de l''idole perdue (succès score 300)", "SUB-022") != 0) return 1;
		if(insertAchievement("QUE-0269", "Kardorim (score 300)", "CHA-060") != 0) return 1;
		if(insertAchievement("QUE-0270", "Tournesol Affamé (score 300)", "CHA-060") != 0) return 1;
		if(insertAchievement("QUE-0271", "Mob l''Éponge (score 300)", "CHA-060") != 0) return 1;
		if(insertAchievement("QUE-0272", "Bouftou Royal (score 300)", "CHA-060") != 0) return 1;
		if(insertAchievement("QUE-0273", "Scarabosse Doré (score 300)", "CHA-060") != 0) return 1;
		if(insertAchievement("QUE-0274", "Batofu (score 300)", "CHA-060") != 0) return 1;
		if(insertAchievement("QUE-0275", "Boostache (score 300)", "CHA-060") != 0) return 1;
		if(insertAchievement("QUE-0276", "Chafer Ronin (score 300)", "CHA-060") != 0) return 1;
		if(insertAchievement("QUE-0277", "Kankreblath (score 300)", "CHA-060") != 0) return 1;
		if(insertAchievement("QUE-0278", "Bworkette (score 300)", "CHA-060") != 0) return 1;
		if(insertAchievement("QUE-0279", "Coffre des Forgerons (score 300)", "CHA-060") != 0) return 1;
		if(insertAchievement("QUE-0280", "Shin Larve (score 300)", "CHA-060") != 0) return 1;
		if(insertAchievement("QUE-0281", "Corailleur Magistral (score 300)", "CHA-060") != 0) return 1;
		if(insertAchievement("QUE-0282", "Kwakwa (score 300)", "CHA-060") != 0) return 1;
		if(insertAchievement("QUE-0283", "Bulbig Brozeur (score 300)", "CHA-060") != 0) return 1;
		if(insertAchievement("SUB-023", "Niveaux 51 à 100", "SUC-03") != 0) return 1;
		if(insertAchievement("CHA-061", "Un pas devant l''autre", "SUB-023") != 0) return 1;
		if(insertAchievement("QUE-0283a", "Bateau du Chouque", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0284", "Château du Wa Wabbit", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0285", "Village Kanniboul", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0286", "Donjon des Blops", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0287", "Laboratoire de Brumen Tinctorias", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0288", "Cale de l''Arche d''Otomaï", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0289", "Donjon des Craqueleurs", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0290", "Gelaxième Dimension", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0291", "Repaire de Daïgoro", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0292", "Terrier du Wa Wabbit", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0293", "Cimetière des Mastodontes", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0294", "Antre de la Reine Nyée", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0295", "Domaine Ancestral", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0296", "Chapiteau des Magik Riktus", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0297", "Antre du Dragon Cochon", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0298", "Caverne Koulosse", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0299", "Tanière du Meulou", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0300", "Arbre de Moon", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0301", "Théâtre de Dramak", "CHA-061") != 0) return 1;
		if(insertAchievement("QUE-0302", "Fabrique de Malléfisk", "CHA-061") != 0) return 1;
		if(insertAchievement("CHA-062", "Acharnement tactique", "SUB-023") != 0) return 1;
		if(insertAchievement("QUE-0303", "Wab wab", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0086", "Wa Wabbit (Hardi)", "QUE-0303") != 0) return 1;
		if(insertAchievement("SBQ-0087", "Wa Wabbit (Blitzkrieg)", "QUE-0303") != 0) return 1;
		if(insertAchievement("SBQ-0088", "Wa Wabbit (Duo)", "QUE-0303") != 0) return 1;
		if(insertAchievement("QUE-0304", "J''ai dégusté son foie avec des fèves au beurre", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0089", "Kanniboul Ebil (Zombie)", "QUE-0304") != 0) return 1;
		if(insertAchievement("SBQ-0090", "Kanniboul Ebil (Premier)", "QUE-0304") != 0) return 1;
		if(insertAchievement("SBQ-0091", "Kanniboul Ebil (Duo)", "QUE-0304") != 0) return 1;
		if(insertAchievement("QUE-0305", "Tout a une fin", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0092", "Blops Royaux (Duel)", "QUE-0305") != 0) return 1;
		if(insertAchievement("SBQ-0093", "Blops Royaux (Pusillanime)", "QUE-0305") != 0) return 1;
		if(insertAchievement("SBQ-0094", "Blops Royaux (Duo)", "QUE-0305") != 0) return 1;
		if(insertAchievement("QUE-0306", "Entre chien et loup", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0095", "Nelween (Dernier)", "QUE-0306") != 0) return 1;
		if(insertAchievement("SBQ-0096", "Nelween (Anachorète)", "QUE-0306") != 0) return 1;
		if(insertAchievement("SBQ-0097", "Nelween (Duo)", "QUE-0306") != 0) return 1;
		if(insertAchievement("QUE-0307", "Les aventuriers de l''Arche d''Otomaï", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0098", "Gourlo le Terrible (Premier)", "QUE-0307") != 0) return 1;
		if(insertAchievement("SBQ-0099", "Gourlo le Terrible (Économe)", "QUE-0307") != 0) return 1;
		if(insertAchievement("SBQ-0100", "Gourlo le Terrible (Duo)", "QUE-0307") != 0) return 1;
		if(insertAchievement("QUE-0308", "Géologie expéditive", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0101", "Craqueleur Légendaire (Pusillanime)", "QUE-0308") != 0) return 1;
		if(insertAchievement("SBQ-0102", "Craqueleur Légendaire (Premier)", "QUE-0308") != 0) return 1;
		if(insertAchievement("SBQ-0103", "Craqueleur Légendaire (Duo)", "QUE-0308") != 0) return 1;
		if(insertAchievement("QUE-0309", "Antigelées", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0104", "Gelées royales (Duel)", "QUE-0309") != 0) return 1;
		if(insertAchievement("SBQ-0105", "Gelées royales (Collant)", "QUE-0309") != 0) return 1;
		if(insertAchievement("SBQ-0106", "Gelées royales (Duo)", "QUE-0309") != 0) return 1;
		if(insertAchievement("QUE-0310", "Pousse de bambou", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0107", "Daïgoro (Pusillanime)", "QUE-0310") != 0) return 1;
		if(insertAchievement("SBQ-0108", "Daïgoro (Premier)", "QUE-0310") != 0) return 1;
		if(insertAchievement("SBQ-0109", "Daïgoro (Duo)", "QUE-0310") != 0) return 1;
		if(insertAchievement("QUE-0311", "Marcher à la cawotte", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0110", "Wa Wobbot (Mains propres)", "QUE-0311") != 0) return 1;
		if(insertAchievement("SBQ-0111", "Wa Wobbot (Blitzkrieg)", "QUE-0311") != 0) return 1;
		if(insertAchievement("SBQ-0112", "Wa Wobbot (Duo)", "QUE-0311") != 0) return 1;
		if(insertAchievement("QUE-0312", "Fromage ou désert", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0113", "Mantiscore (Mains propres)", "QUE-0312") != 0) return 1;
		if(insertAchievement("SBQ-0114", "Mantiscore (Zombie)", "QUE-0312") != 0) return 1;
		if(insertAchievement("SBQ-0115", "Mantiscore (Duo)", "QUE-0312") != 0) return 1;
		if(insertAchievement("QUE-0313", "Les pieds dans la toile", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0116", "Raine Nyée (Premier)", "QUE-0313") != 0) return 1;
		if(insertAchievement("SBQ-0117", "Raine Nyée (Hardi)", "QUE-0313") != 0) return 1;
		if(insertAchievement("SBQ-0118", "Raine Nyée (Duo)", "QUE-0313") != 0) return 1;
		if(insertAchievement("QUE-0314", "Abrakadabra", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0119", "Abraknyde Ancestral (Nomade)", "QUE-0314") != 0) return 1;
		if(insertAchievement("SBQ-0120", "Abraknyde Ancestral (Premier)", "QUE-0314") != 0) return 1;
		if(insertAchievement("SBQ-0121", "Abraknyde Ancestral (Duo)", "QUE-0314") != 0) return 1;
		if(insertAchievement("QUE-0315", "Un trésor bien enfoui", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0122", "Le Chouque (Nomade)", "QUE-0315") != 0) return 1;
		if(insertAchievement("SBQ-0123", "Le Chouque (Dernier)", "QUE-0315") != 0) return 1;
		if(insertAchievement("SBQ-0124", "Le Chouque (Duo)", "QUE-0315") != 0) return 1;
		if(insertAchievement("QUE-0316", "Sous le plus grand chapiteau du monde", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0125", "Choudini (Collant)", "QUE-0316") != 0) return 1;
		if(insertAchievement("SBQ-0126", "Choudini (Hardi)", "QUE-0316") != 0) return 1;
		if(insertAchievement("SBQ-0127", "Choudini (Duo)", "QUE-0316") != 0) return 1;
		if(insertAchievement("QUE-0317", "Tout est bon dans le cochon", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0128", "Dragon Cochon (Hardi)", "QUE-0317") != 0) return 1;
		if(insertAchievement("SBQ-0129", "Dragon Cochon (Versatile)", "QUE-0317") != 0) return 1;
		if(insertAchievement("SBQ-0130", "Dragon Cochon (Duo)", "QUE-0317") != 0) return 1;
		if(insertAchievement("QUE-0318", "Dans la brume éclectique", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0131", "Koulosse (Zombie)", "QUE-0318") != 0) return 1;
		if(insertAchievement("SBQ-0132", "Koulosse (Mains propres)", "QUE-0318") != 0) return 1;
		if(insertAchievement("SBQ-0133", "Koulosse (Duo)", "QUE-0318") != 0) return 1;
		if(insertAchievement("QUE-0319", "Bovidé enragé", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0134", "Meulou (Premier)", "QUE-0319") != 0) return 1;
		if(insertAchievement("SBQ-0135", "Meulou (Hardi)", "QUE-0319") != 0) return 1;
		if(insertAchievement("SBQ-0136", "Meulou (Duo)", "QUE-0319") != 0) return 1;
		if(insertAchievement("QUE-0320", "Moon dans la brume", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0137", "Moon (Versatile)", "QUE-0320") != 0) return 1;
		if(insertAchievement("SBQ-0138", "Moon (Statue)", "QUE-0320") != 0) return 1;
		if(insertAchievement("SBQ-0139", "Moon (Duo)", "QUE-0320") != 0) return 1;
		if(insertAchievement("QUE-0321", "Théâtre des marionnettes", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0140", "Maître des Pantins (Statue)", "QUE-0321") != 0) return 1;
		if(insertAchievement("SBQ-0141", "Maître des Pantins (Mains Prores)", "QUE-0321") != 0) return 1;
		if(insertAchievement("SBQ-0142", "Maître des Pantins (Duo)", "QUE-0321") != 0) return 1;
		if(insertAchievement("QUE-0322", "Rompre Malléfisk", "CHA-062") != 0) return 1;
		if(insertAchievement("SBQ-0143", "Malléfisk (Circulez)", "QUE-0322") != 0) return 1;
		if(insertAchievement("SBQ-0144", "Malléfisk (Blitzkrieg)", "QUE-0322") != 0) return 1;
		if(insertAchievement("SBQ-0145", "Malléfisk (Duo)", "QUE-0322") != 0) return 1;
		if(insertAchievement("CHA-063", "Les sentiers de la gloire (succès score 300)", "SUB-023") != 0) return 1;
		if(insertAchievement("QUE-0322a", "Le Chouque (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0323", "Wa Wabbit (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0324", "Kanniboul Ebil (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0325", "Blops Royaux (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0326", "Nelween (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0327", "Gourlo le Terrible (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0328", "Craqueleur Légendaire (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0329", "Gelées Royales (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0330", "Daïgoro (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0331", "Wo Wobot (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0332", "Mantiscore (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0333", "Reine Nyée (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0334", "Abraknyde Ancestral (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0335", "Choudini (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0336", "Dragon Cochon (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0337", "Koulosse (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0338", "Meulou (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0339", "Moon (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0340", "Maître des Pantins (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("QUE-0341", "Malléfisk (score 300)", "CHA-063") != 0) return 1;
		if(insertAchievement("SUB-024", "Niveaux 101 à 150", "SUC-03") != 0) return 1;
		if(insertAchievement("CHA-064", "Là où je passe, les monstres ne réapparaissent plus", "SUB-024") != 0) return 1;
		if(insertAchievement("QUE-0341a", "Miausolée du Pounicheur", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0342", "Goulet du Rasboul", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0343", "Bibliothèque du Maître Corbac", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0344", "Donjon des Rats de Bonta", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0345", "Donjon des Rats de Brâkmar", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0346", "Antre du Blop Multicolore Royal", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0347", "Centre du Labyrinthe du Minotoror", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0348", "Serre du Royalmouth", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0349", "Repaire des Pandikazes", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0350", "Tofulailler Royal", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0351", "Donjon des Dragoeufs", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0352", "Repaire de Skeunk", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0353", "Mégalithe de Fraktale", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0354", "Donjon des Kitsounes", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0355", "Volière de la Haute Truche", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0356", "Caverne d''El Piko", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0357", "Ring du Capitaine Ekarlatte", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0358", "Donjon des Firefoux", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0359", "Clairière du Chêne Mou", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0360", "Laboratoire du Tynril", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0361", "Excavation du Mansot Royal", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0362", "Épave du Grolandais violent", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0363", "Donjon des Rats du Château d''Amakna", "CHA-064") != 0) return 1;
		if(insertAchievement("QUE-0364", "Galerie du Phossile", "CHA-064") != 0) return 1;
		if(insertAchievement("CHA-065", "Tactique payante", "SUB-024") != 0) return 1;
		if(insertAchievement("QUE-0365", "Goulet d''étranglement", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0146", "Silf le Rasboul Majeur (Premier)", "QUE-0365") != 0) return 1;
		if(insertAchievement("SBQ-0147", "Silf le Rasboul Majeur (Temps qui court)", "QUE-0365") != 0) return 1;
		if(insertAchievement("SBQ-0148", "Silf le Rasboul Majeur (Duo)", "QUE-0365") != 0) return 1;
		if(insertAchievement("QUE-0366", "Scélérat de bibliothèque", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0149", "Maître Corbac (Collant)", "QUE-0366") != 0) return 1;
		if(insertAchievement("SBQ-0150", "Maître Corbac (Premier)", "QUE-0366") != 0) return 1;
		if(insertAchievement("SBQ-0151", "Maître Corbac (Duo)", "QUE-0366") != 0) return 1;
		if(insertAchievement("QUE-0367", "Sans rature", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0152", "Rat Blanc (Premier)", "QUE-0367") != 0) return 1;
		if(insertAchievement("SBQ-0153", "Rat Blanc (Hardi)", "QUE-0367") != 0) return 1;
		if(insertAchievement("SBQ-0154", "Rat Blanc (Duo)", "QUE-0367") != 0) return 1;
		if(insertAchievement("QUE-0368", "Ravalement de donjon", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0155", "Rat Noir (Hardi)", "QUE-0368") != 0) return 1;
		if(insertAchievement("SBQ-0156", "Rat Noir (Blitzkrieg)", "QUE-0368") != 0) return 1;
		if(insertAchievement("SBQ-0157", "Rat Noir (Duo)", "QUE-0368") != 0) return 1;
		if(insertAchievement("QUE-0369", "Bloportunité à saisir", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0158", "Blop Multicolore Royal (Hardi)", "QUE-0369") != 0) return 1;
		if(insertAchievement("SBQ-0159", "Blop Multicolore Royal (Duel)", "QUE-0369") != 0) return 1;
		if(insertAchievement("SBQ-0160", "Blop Multicolore Royal (Duo)", "QUE-0369") != 0) return 1;
		if(insertAchievement("QUE-0370", "Tâter le Pou", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0161", "Pounicheur (Blitzkrieg)", "QUE-0370") != 0) return 1;
		if(insertAchievement("SBQ-0162", "Pounicheur (Statue)", "QUE-0370") != 0) return 1;
		if(insertAchievement("SBQ-0163", "Pounicheur (Duo)", "QUE-0370") != 0) return 1;
		if(insertAchievement("QUE-0371", "Prendre le Minotoror par les cornes", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0164", "Minotoror (Anachorète)", "QUE-0371") != 0) return 1;
		if(insertAchievement("SBQ-0165", "Minotoror (Mains propres)", "QUE-0371") != 0) return 1;
		if(insertAchievement("SBQ-0166", "Minotoror (Duo)", "QUE-0371") != 0) return 1;
		if(insertAchievement("QUE-0372", "Le détour du Roi", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0167", "Royalmouth (Mains propres)", "QUE-0372") != 0) return 1;
		if(insertAchievement("SBQ-0168", "Royalmouth (Premier)", "QUE-0372") != 0) return 1;
		if(insertAchievement("SBQ-0169", "Royalmouth (Duo)", "QUE-0372") != 0) return 1;
		if(insertAchievement("QUE-0373", "Pandikazetagne", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0170", "Maître Pandore (Premier)", "QUE-0373") != 0) return 1;
		if(insertAchievement("SBQ-0171", "Maître Pandore (Collant)", "QUE-0373") != 0) return 1;
		if(insertAchievement("SBQ-0172", "Maître Pandore (Duo)", "QUE-0373") != 0) return 1;
		if(insertAchievement("QUE-0374", "Vol au dessus d''un nid de Tofus", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0173", "Tofu Royal (Dernier)", "QUE-0374") != 0) return 1;
		if(insertAchievement("SBQ-0174", "Tofu Royal (Statue)", "QUE-0374") != 0) return 1;
		if(insertAchievement("SBQ-0175", "Tofu Royal (Duo)", "QUE-0374") != 0) return 1;
		if(insertAchievement("QUE-0375", "Dragon rouge", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0176", "Crocabulia (Collant)", "QUE-0375") != 0) return 1;
		if(insertAchievement("SBQ-0177", "Crocabulia (Blitzkrieg)", "QUE-0375") != 0) return 1;
		if(insertAchievement("SBQ-0178", "Crocabulia (Duo)", "QUE-0375") != 0) return 1;
		if(insertAchievement("QUE-0376", "Animal totem", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0179", "Skeunk (Statue)", "QUE-0376") != 0) return 1;
		if(insertAchievement("SBQ-0180", "Skeunk (Blitzkrieg)", "QUE-0376") != 0) return 1;
		if(insertAchievement("SBQ-0181", "Skeunk (Duo)", "QUE-0376") != 0) return 1;
		if(insertAchievement("QUE-0377", "Un passé trouble", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0182", "Fraktale (Anachorète)", "QUE-0377") != 0) return 1;
		if(insertAchievement("SBQ-0183", "Fraktale (Blitzkrieg)", "QUE-0377") != 0) return 1;
		if(insertAchievement("SBQ-0184", "Fraktale (Duo)", "QUE-0377") != 0) return 1;
		if(insertAchievement("QUE-0378", "La belle paire", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0185", "Tanukouï San (Focus)", "QUE-0378") != 0) return 1;
		if(insertAchievement("SBQ-0186", "Tanukouï San (Hardi)", "QUE-0378") != 0) return 1;
		if(insertAchievement("SBQ-0187", "Tanukouï San (Duo)", "QUE-0378") != 0) return 1;
		if(insertAchievement("QUE-0379", "La politique de la Haute Truche", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0188", "Haute Truche (Premier)", "QUE-0379") != 0) return 1;
		if(insertAchievement("SBQ-0189", "Haute Truche (Barbare)", "QUE-0379") != 0) return 1;
		if(insertAchievement("SBQ-0190", "Haute Truche (Duo)", "QUE-0379") != 0) return 1;
		if(insertAchievement("QUE-0380", "Caramba", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0191", "El Piko (Blitzkrieg)", "QUE-0380") != 0) return 1;
		if(insertAchievement("SBQ-0192", "El Piko (Duel)", "QUE-0380") != 0) return 1;
		if(insertAchievement("SBQ-0193", "El Piko (Duo)", "QUE-0380") != 0) return 1;
		if(insertAchievement("QUE-0381", "Grand Ekarlatte", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0194", "Capitaine Ekarlatte (Focus)", "QUE-0381") != 0) return 1;
		if(insertAchievement("SBQ-0195", "Capitaine Ekarlatte (Statue)", "QUE-0381") != 0) return 1;
		if(insertAchievement("SBQ-0196", "Capitaine Ekarlatte (Duo)", "QUE-0381") != 0) return 1;
		if(insertAchievement("QUE-0382", "Un après-midi de chien", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0197", "Péki Péki (Statue)", "QUE-0382") != 0) return 1;
		if(insertAchievement("SBQ-0198", "Péki Péki (Hardi)", "QUE-0382") != 0) return 1;
		if(insertAchievement("SBQ-0199", "Péki Péki (Duo)", "QUE-0382") != 0) return 1;
		if(insertAchievement("QUE-0383", "Mou du genou", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0200", "Chêne Mou (Liberté)", "QUE-0383") != 0) return 1;
		if(insertAchievement("SBQ-0201", "Chêne Mou (Premier)", "QUE-0383") != 0) return 1;
		if(insertAchievement("SBQ-0202", "Chêne Mou (Duo)", "QUE-0383") != 0) return 1;
		if(insertAchievement("QUE-0384", "Refactorisation terminée", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0203", "Tynrils (Intouchable)", "QUE-0384") != 0) return 1;
		if(insertAchievement("SBQ-0204", "Tynrils (Zombie)", "QUE-0384") != 0) return 1;
		if(insertAchievement("SBQ-0205", "Tynrils (Duo)", "QUE-0384") != 0) return 1;
		if(insertAchievement("QUE-0385", "La marche de l''empereur", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0206", "Mansot Royal (Dernier)", "QUE-0385") != 0) return 1;
		if(insertAchievement("SBQ-0207", "Mansot Royal (Collant)", "QUE-0385") != 0) return 1;
		if(insertAchievement("SBQ-0208", "Mansot Royal (Duo)", "QUE-0385") != 0) return 1;
		if(insertAchievement("QUE-0386", "Le coup de pied marin", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0209", "Ben le Ripate (Circulez)", "QUE-0386") != 0) return 1;
		if(insertAchievement("SBQ-0210", "Ben le Ripate (Statue)", "QUE-0386") != 0) return 1;
		if(insertAchievement("SBQ-0211", "Ben le Ripate (Duo)", "QUE-0386") != 0) return 1;
		if(insertAchievement("QUE-0387", "Théorie du cachot", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0212", "Sphincter Cell (Hardi)", "QUE-0387") != 0) return 1;
		if(insertAchievement("SBQ-0213", "Sphincter Cell (Dernier)", "QUE-0387") != 0) return 1;
		if(insertAchievement("SBQ-0214", "Sphincter Cell (Duo)", "QUE-0387") != 0) return 1;
		if(insertAchievement("QUE-0388", "Le musée des Phorreurs", "CHA-065") != 0) return 1;
		if(insertAchievement("SBQ-0215", "Phossile (Hardi)", "QUE-0388") != 0) return 1;
		if(insertAchievement("SBQ-0216", "Phossile (Liberté)", "QUE-0388") != 0) return 1;
		if(insertAchievement("SBQ-0217", "Phossile (Duo)", "QUE-0388") != 0) return 1;
		if(insertAchievement("CHA-066", "Le prestige (succès score 300)", "SUB-024") != 0) return 1;
		if(insertAchievement("QUE-0389", "Silf le Rasboul Majeur (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0390", "Maître Corbac (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0391", "Rat Blanc (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0392", "Rat Noir (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0393", "Pounicheur (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0394", "Blop Multicolore Royal (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0395", "Minotoror (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0396", "Royalmouth (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0397", "Maître Pandore (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0398", "Tofu Royal (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0399", "Crocabulia (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0400", "Skeunk (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0401", "Fraktale (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0402", "Tanukouï San", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0403", "Haute Truche (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0404", "El Piko (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0405", "Le Capitaine Ekarlatte (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0406", "Péki Péki (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0407", "Chêne Mou (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0408", "Tynril (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0409", "Mansot Royal (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0410", "Ben le Ripate (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0411", "Sphincter Cell (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("QUE-0412", "Phossile (score 300)", "CHA-066") != 0) return 1;
		if(insertAchievement("SUB-025", "Niveaux 151 à 190", "SUC-03") != 0) return 1;
		if(insertAchievement("CHA-067", "Je suis une légende", "SUB-025") != 0) return 1;
		if(insertAchievement("QUE-0413", "Canopée du Kimbo", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0414", "Salle du Minotot", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0415", "Hypogée de l''Obsidiantre", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0416", "Grotte de Kanigroula", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0417", "Cavernes Givrefoux", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0418", "Boyau du Père Ver", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0419", "Horologium de XLII", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0420", "Antre du Korriandre", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0421", "Antre du Kralamoure Géant", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0422", "Donjon du Bworker", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0423", "Donjon Fungus", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0424", "Cave du Toxoliath", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0425", "Cavernes du Kolosso", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0426", "Fuji Govrefoux Nourricière", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0427", "Mine de Sakaï", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0428", "Antichambre des Gloursons", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0429", "Pyramide d''Ombre", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0430", "Camp du Comte Razof", "CHA-067") != 0) return 1;
		if(insertAchievement("QUE-0431", "Plateau de Ush", "CHA-067") != 0) return 1;
		if(insertAchievement("CHA-068", "Destination finale", "SUB-025") != 0) return 1;
		if(insertAchievement("QUE-0432", "Pair et impair", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0218", "Kimbo (Statue)", "QUE-0432") != 0) return 1;
		if(insertAchievement("SBQ-0219", "Kimbo (Premier)", "QUE-0432") != 0) return 1;
		if(insertAchievement("SBQ-0220", "Kimbo (Duo)", "QUE-0432") != 0) return 1;
		if(insertAchievement("QUE-0433", "Réception de Tofu", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0221", "Minotot (Circulez)", "QUE-0433") != 0) return 1;
		if(insertAchievement("SBQ-0222", "Minotot (Premier)", "QUE-0433") != 0) return 1;
		if(insertAchievement("SBQ-0223", "Minotot (Duo)", "QUE-0433") != 0) return 1;
		if(insertAchievement("QUE-0434", "Fichtre", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0224", "Obsidiantre (Premier)", "QUE-0434") != 0) return 1;
		if(insertAchievement("SBQ-0225", "Obsidiantre (Statue)", "QUE-0434") != 0) return 1;
		if(insertAchievement("SBQ-0226", "Obsidiantre (Duo)", "QUE-0443") != 0) return 1;
		if(insertAchievement("QUE-0435", "Décollation de seize heure", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0227", "Kanigroula (Premier)", "QUE-0435") != 0) return 1;
		if(insertAchievement("SBQ-0228", "Kanigroula (Hardi)", "QUE-0435") != 0) return 1;
		if(insertAchievement("SBQ-0229", "Kanigroula (Duo)", "QUE-0435") != 0) return 1;
		if(insertAchievement("QUE-0436", "Givre mort", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0230", "Tengu Givrefoux (Premier)", "QUE-0436") != 0) return 1;
		if(insertAchievement("SBQ-0231", "Tengu Givrefoux (Statue)", "QUE-0436") != 0) return 1;
		if(insertAchievement("SBQ-0232", "Tengu Givrefoux (Duo)", "QUE-0436") != 0) return 1;
		if(insertAchievement("QUE-0437", "Le chant des dunes", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0233", "Père Ver (Premier)", "QUE-0437") != 0) return 1;
		if(insertAchievement("SBQ-0234", "Père Ver (Zombie)", "QUE-0437") != 0) return 1;
		if(insertAchievement("SBQ-0235", "Père Ver (Duo)", "QUE-0437") != 0) return 1;
		if(insertAchievement("QUE-0438", "Six fois neuf", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0236", "XLII (Barbare)", "QUE-0438") != 0) return 1;
		if(insertAchievement("SBQ-0237", "XLII (Collant)", "QUE-0438") != 0) return 1;
		if(insertAchievement("SBQ-0238", "XLII (Duo)", "QUE-0438") != 0) return 1;
		if(insertAchievement("QUE-0439", "Coup de Glyphe", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0239", "Korriandre (Mystique)", "QUE-0439") != 0) return 1;
		if(insertAchievement("SBQ-0240", "Korriandre (Zombie)", "QUE-0439") != 0) return 1;
		if(insertAchievement("SBQ-0241", "Korriandre (Duo)", "QUE-0439") != 0) return 1;
		if(insertAchievement("QUE-0440", "Kralamoure propre", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0242", "Kralamoure Géant (Nomade)", "QUE-0440") != 0) return 1;
		if(insertAchievement("SBQ-0243", "Kralamoure Géant (Blitzkrieg)", "QUE-0440") != 0) return 1;
		if(insertAchievement("SBQ-0244", "Kralamoure Géant (Duo)", "QUE-0440") != 0) return 1;
		if(insertAchievement("QUE-0441", "Bworker Texas Ranger", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0245", "Bworker (Hardi)", "QUE-0441") != 0) return 1;
		if(insertAchievement("SBQ-0246", "Bworker (Blitzkrieg)", "QUE-0441") != 0) return 1;
		if(insertAchievement("SBQ-0247", "Bworker (Duo)", "QUE-0441") != 0) return 1;
		if(insertAchievement("QUE-0442", "Fongicide", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0248", "Ougah (Collant)", "QUE-0442") != 0) return 1;
		if(insertAchievement("SBQ-0249", "Ougah (Dernier)", "QUE-0442") != 0) return 1;
		if(insertAchievement("SBQ-0250", "Ougah (Duo)", "QUE-0442") != 0) return 1;
		if(insertAchievement("QUE-0443", "Désintoxoliathisation", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0251", "Toxoliath (Circulez)", "QUE-0443") != 0) return 1;
		if(insertAchievement("SBQ-0252", "Toxoliath (Anachorète)", "QUE-0443") != 0) return 1;
		if(insertAchievement("SBQ-0253", "Toxoliath (Duo)", "QUE-0443") != 0) return 1;
		if(insertAchievement("QUE-0444", "Permutation génétique", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0254", "Kolosso (Dernier) (Blérom)", "QUE-0444") != 0) return 1;
		if(insertAchievement("SBQ-0255", "Kolosso (Premier) (Professeur Xa)", "QUE-0444") != 0) return 1;
		if(insertAchievement("SBQ-0256", "Kolosso (Duo)", "QUE-0444") != 0) return 1;
		if(insertAchievement("QUE-0445", "Garde-foux", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0257", "Fuji Givrefoux Nourricière (Dernier)", "QUE-0445") != 0) return 1;
		if(insertAchievement("SBQ-0258", "Fuji Givrefoux Nourricière (Statue)", "QUE-0445") != 0) return 1;
		if(insertAchievement("SBQ-0259", "Fuji Givrefoux Nourricière (Duo)", "QUE-0445") != 0) return 1;
		if(insertAchievement("QUE-0446", "Ce Gob a mauvaise mine", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0260", "Grolloum (Versatile)", "QUE-0446") != 0) return 1;
		if(insertAchievement("SBQ-0261", "Grolloum (Blitzkrieg)", "QUE-0446") != 0) return 1;
		if(insertAchievement("SBQ-0262", "Grolloum (Duo)", "QUE-0446") != 0) return 1;
		if(insertAchievement("QUE-0447", "Vendre la peau du Glours", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0263", "Glourséleste (Premier)", "QUE-0447") != 0) return 1;
		if(insertAchievement("SBQ-0264", "Glourséleste (Collant)", "QUE-0447") != 0) return 1;
		if(insertAchievement("SBQ-0265", "Glourséleste (Duo)", "QUE-0447") != 0) return 1;
		if(insertAchievement("QUE-0448", "Entre Ombre et lumière", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0266", "Ombre (Premier)", "QUE-0448") != 0) return 1;
		if(insertAchievement("SBQ-0267", "Ombre (Collant)", "QUE-0448") != 0) return 1;
		if(insertAchievement("SBQ-0268", "Ombre (Duo)", "QUE-0448") != 0) return 1;
		if(insertAchievement("QUE-0449", "Les chasses du Comte Razof", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0269", "Comte Razof (Liberté)", "QUE-0449") != 0) return 1;
		if(insertAchievement("SBQ-0270", "Comte Razof (Premier)", "QUE-0449") != 0) return 1;
		if(insertAchievement("SBQ-0271", "Comte Razof (Duo)", "QUE-0449") != 0) return 1;
		if(insertAchievement("QUE-0450", "Faire l''autre Ush", "CHA-068") != 0) return 1;
		if(insertAchievement("SBQ-0272", "Ush Galesh (Premier)", "QUE-0450") != 0) return 1;
		if(insertAchievement("SBQ-0273", "Ush Galesh (Zombie)", "QUE-0450") != 0) return 1;
		if(insertAchievement("SBQ-0274", "Ush Galesh (Duo)", "QUE-0450") != 0) return 1;
		if(insertAchievement("CHA-069", "L''idole dans la peau (succès score 300)", "SUB-025") != 0) return 1;
		if(insertAchievement("QUE-0451", "Kimbo (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0452", "Minotot (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0453", "Obsidiantre (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0454", "Kanigroula (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0455", "Tengu Givrefoux (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0456", "Père Ver (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0457", "XLII (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0458", "Korriandre (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0459", "Kralamoure Géant (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0460", "Bworker (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0461", "Ougah (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0462", "Toxoliath (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0463", "Kolosso (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0464", "Fuji Givrefoux Nourricière (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0465", "Grolloum (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0466", "Glourséléste (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0467", "Ombre (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("QUE-0468", "Comte Razof (score 300)", "CHA-069") != 0) return 1;
		if(insertAchievement("SUB-026", "Niveaux 191 à 200", "SUC-03") != 0) return 1;
		if(insertAchievement("CHA-070", "Apocalypse snow", "SUB-026") != 0) return 1;
		if(insertAchievement("QUE-0469", "Forgefroide de Missiz Frizz", "CHA-070") != 0) return 1;
		if(insertAchievement("QUE-0470", "Transporteur de Sylargh", "CHA-070") != 0) return 1;
		if(insertAchievement("QUE-0471", "Salons privés de Klime", "CHA-070") != 0) return 1;
		if(insertAchievement("QUE-0472", "Laboratoire de Nileza", "CHA-070") != 0) return 1;
		if(insertAchievement("QUE-0473", "Donjon du Comte", "CHA-070") != 0) return 1;
		if(insertAchievement("CHA-071", "Crise de froid", "SUB-026") != 0) return 1;
		if(insertAchievement("QUE-0474", "Culotte glaciaire", "CHA-071") != 0) return 1;
		if(insertAchievement("SBQ-0275", "Missiz Frizz (Nomade)", "QUE-0474") != 0) return 1;
		if(insertAchievement("SBQ-0276", "Missiz Frizz (Collant)", "QUE-0474") != 0) return 1;
		if(insertAchievement("SBQ-0277", "Missiz Frizz (Duo)", "QUE-0474") != 0) return 1;
		if(insertAchievement("QUE-0475", "Mécanique antique", "CHA-071") != 0) return 1;
		if(insertAchievement("SBQ-0278", "Sylargh (Anachorète)", "QUE-0475") != 0) return 1;
		if(insertAchievement("SBQ-0279", "Sylargh (Barbare)", "QUE-0475") != 0) return 1;
		if(insertAchievement("SBQ-0280", "Sylargh (Duo)", "QUE-0475") != 0) return 1;
		if(insertAchievement("QUE-0476", "Dur à cuir", "CHA-071") != 0) return 1;
		if(insertAchievement("SBQ-0281", "Klime (Pusillanime)", "QUE-0476") != 0) return 1;
		if(insertAchievement("SBQ-0282", "Klime (Nomade)", "QUE-0476") != 0) return 1;
		if(insertAchievement("SBQ-0283", "Klime (Duo)", "QUE-0476") != 0) return 1;
		if(insertAchievement("QUE-0477", "Alchimie orgainique", "CHA-071") != 0) return 1;
		if(insertAchievement("SBQ-0284", "Nileza (Pusillanime)", "QUE-0477") != 0) return 1;
		if(insertAchievement("SBQ-0285", "Nileza (Dernier)", "QUE-0477") != 0) return 1;
		if(insertAchievement("SBQ-0286", "Nileza (Duo)", "QUE-0477") != 0) return 1;
		if(insertAchievement("QUE-0478", "À rebours", "CHA-071") != 0) return 1;
		if(insertAchievement("SBQ-0287", "Comte Harebourg (Versatile)", "QUE-0478") != 0) return 1;
		if(insertAchievement("SBQ-0288", "Comte Harebourg (Statue)", "QUE-0478") != 0) return 1;
		if(insertAchievement("SBQ-0289", "Comte Harebourg (Duo)", "QUE-0478") != 0) return 1;
		if(insertAchievement("CHA-072", "Pas d''idole, pas de gloire", "SUB-026") != 0) return 1;
		if(insertAchievement("QUE-0479", "Missiz Frizz (score 300)", "CHA-072") != 0) return 1;
		if(insertAchievement("QUE-0480", "Sylargh (score 300)", "CHA-072") != 0) return 1;
		if(insertAchievement("QUE-0481", "Klime (score 300)", "CHA-072") != 0) return 1;
		if(insertAchievement("QUE-0482", "Nileza (score 300)", "CHA-072") != 0) return 1;
		if(insertAchievement("QUE-0483", "Comte Harebourg (score 300)", "CHA-072") != 0) return 1;
		if(insertAchievement("CHA-073", "Autres", "SUB-026") != 0) return 1;
		if(insertAchievement("QUE-0484", "Les 5 Fantastiques", "CHA-073") != 0) return 1;
		if(insertAchievement("SBQ-0290", "Harebourg et Frizz", "QUE-0484") != 0) return 1;
		if(insertAchievement("SBQ-0291", "Harebourg et Sylargh", "QUE-0484") != 0) return 1;
		if(insertAchievement("SBQ-0292", "Harebourg et Klime", "QUE-0484") != 0) return 1;
		if(insertAchievement("SBQ-0293", "Harebourg et Nileza", "QUE-0484") != 0) return 1;
		if(insertAchievement("QUE-0485", "Se jeter à l''eau", "CHA-073") != 0) return 1;
		if(insertAchievement("SBQ-0293a", "Merkator (Dernier)", "QUE-0485") != 0) return 1;
		if(insertAchievement("SBQ-0294", "Merkator (Mystique)", "QUE-0485") != 0) return 1;
		if(insertAchievement("SBQ-0295", "Merkator (Duo)", "QUE-0485") != 0) return 1;
		if(insertAchievement("QUE-0486", "Votre Seniorie", "CHA-073") != 0) return 1;
		if(insertAchievement("SBQ-0296", "Roi Nidas (Premier)", "QUE-0486") != 0) return 1;
		if(insertAchievement("SBQ-0297", "Roi Nidas (Statue)", "QUE-0486") != 0) return 1;
		if(insertAchievement("SBQ-0298", "Roi Nidas (Trio)", "QUE-0486") != 0) return 1;
		if(insertAchievement("QUE-0487", "Voligarchie", "CHA-073") != 0) return 1;
		if(insertAchievement("SBQ-0299", "Reine des voleurs (Premier)", "QUE-0487") != 0) return 1;
		if(insertAchievement("SBQ-0300", "Reine des voleurs (Collant)", "QUE-0487") != 0) return 1;
		if(insertAchievement("SBQ-0301", "Reine des voleurs (Trio)", "QUE-0487") != 0) return 1;
		if(insertAchievement("QUE-0488", "Système humanitaire", "CHA-073") != 0) return 1;
		if(insertAchievement("SBQ-0302", "Protozorreur (Barbare)", "QUE-0488") != 0) return 1;
		if(insertAchievement("SBQ-0303", "Protozorreur (Statue)", "QUE-0488") != 0) return 1;
		if(insertAchievement("SBQ-0304", "Protozorreur (Duo)", "QUE-0488") != 0) return 1;
		if(insertAchievement("QUE-0489", "Vortexicomane", "CHA-073") != 0) return 1;
		if(insertAchievement("SBQ-0305", "Vortex (Focus)", "QUE-0489") != 0) return 1;
		if(insertAchievement("SBQ-0306", "Vortex (Hardi)", "QUE-0489") != 0) return 1;
		if(insertAchievement("SBQ-0307", "Vortex (Trio)", "QUE-0489") != 0) return 1;
		if(insertAchievement("QUE-0490", "Le Défibrillateur", "CHA-073") != 0) return 1;
		if(insertAchievement("SBQ-0308", "Chaloeil (Liberté)", "QUE-0490") != 0) return 1;
		if(insertAchievement("SBQ-0309", "Chaloeil (Pusillanime)", "QUE-0490") != 0) return 1;
		if(insertAchievement("SBQ-0310", "Chaloeil (Trio)", "QUE-0490") != 0) return 1;
		if(insertAchievement("QUE-0491", "Mobilis in Mobili", "CHA-073") != 0) return 1;
		if(insertAchievement("SBQ-0311", "Capitaine Meno (Blitzkrieg)", "QUE-0491") != 0) return 1;
		if(insertAchievement("SBQ-0312", "Capitaine Meno (Pusillanime)", "QUE-0491") != 0) return 1;
		if(insertAchievement("SBQ-0313", "Capitaine Meno (Duo)", "QUE-0491") != 0) return 1;
		if(insertAchievement("QUE-0492", "Koutoulou R''lyugluglu fhtagn", "CHA-073") != 0) return 1;
		if(insertAchievement("SBQ-0314", "Larve de Koutoulou (Pusillanime)", "QUE-0492") != 0) return 1;
		if(insertAchievement("SBQ-0315", "Larve de Koutoulou (Hardi)", "QUE-0492") != 0) return 1;
		if(insertAchievement("SBQ-0316", "Larve de Koutoulou (Duo)", "QUE-0492") != 0) return 1;
		if(insertAchievement("QUE-0493", "Sous l''océan", "CHA-073") != 0) return 1;
		if(insertAchievement("SBQ-0317", "Dantinéa (Dernier)", "QUE-0493") != 0) return 1;
		if(insertAchievement("SBQ-0318", "Dantinéa (Statue)", "QUE-0493") != 0) return 1;
		if(insertAchievement("SBQ-0319", "Dantinéa (Duo)", "QUE-0493") != 0) return 1;
		if(insertAchievement("QUE-0494", "La Reine des damnés", "CHA-073") != 0) return 1;
		if(insertAchievement("SBQ-0320", "Tal Kasha (Focus)", "QUE-0494") != 0) return 1;
		if(insertAchievement("SBQ-0321", "Tal Kasha (Statue)", "QUE-0494") != 0) return 1;
		if(insertAchievement("SBQ-0322", "Tal Kasha (Duo)", "QUE-0494") != 0) return 1;
		if(insertAchievement("QUE-0495", "Rase les goules", "CHA-073") != 0) return 1;
		if(insertAchievement("SBQ-0323", "Anerice la Shushess (Pusillanime)", "QUE-0495") != 0) return 1;
		if(insertAchievement("SBQ-0324", "Anerice la Shushess (Premier)", "QUE-0495") != 0) return 1;
		if(insertAchievement("SBQ-0325", "Anerice la Shushess (Duo)", "QUE-0495") != 0) return 1;
		if(insertAchievement("CHA-074", "Autres Bis", "SUB-026") != 0) return 1;
		if(insertAchievement("QUE-0496", "Aquadôme de Merkator", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0497", "Merkator (score 300)", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0498", "Palais du Roi Nidas", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0499", "Roi Nidas (score 300)", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0500", "Trône de la cour sombre", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0501", "Reine des voleurs (score 300)", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0502", "Ventre de la baleine", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0503", "Protozorreur (score 300)", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0504", "Oeil de vortex", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0505", "Vortex (score 300)", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0506", "Défi du Chaloeil", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0507", "Chaloeil (score 300)", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0508", "Vaisseau du Capitaine Meno", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0509", "Capitaine Meno (score 300)", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0510", "Temple de Koutoulou", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0511", "Larve de Koutoulou (score 300)", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0512", "Palais de Dantinéa", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0513", "Dantinéa (score 300)", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0514", "Chambre de Tal Kasha", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0515", "Tal Kasha (score 300)", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0516", "Manoir des Katrepat", "CHA-074") != 0) return 1;
		if(insertAchievement("QUE-0517", "Anerice la Shushess (score 300)", "CHA-074") != 0) return 1;
		
		// MONSTRES
		if(insertAchievement("SUB-027", "Général", "SUC-04") != 0) return 1;
		if(insertAchievement("CHA-075", "Promenade sans thé (1 challenge)", "SUB-027") != 0) return 1;
		if(insertAchievement("CHA-076", "Sans les mains (10 challenges)", "SUB-027") != 0) return 1;
		if(insertAchievement("CHA-077", "Challenge accepté (100 challenges)", "SUB-027") != 0) return 1;
		if(insertAchievement("CHA-078", "Chalongeur (1000 challenges)", "SUB-027") != 0) return 1;
		if(insertAchievement("CHA-079", "Trappeur et sans reproches (Succès monstre)", "SUB-027") != 0) return 1;
		if(insertAchievement("CHA-080", "Et au milieu coule une rivière. De sang.", "SUB-027") != 0) return 1;
		
		if(insertAchievement("SUB-028", "Dopeuls", "SUC-04") != 0) return 1;
		
		if(insertAchievement("CHA-081", "Je vous prends tous", "SUB-028") != 0) return 1;
		
		if(insertAchievement("QUE-0518", "Dopeul Crâ", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0519", "Dopeul Ecaflip", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0520", "Dopeul Eliotrope", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0521", "Dopeul Eniripsa", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0522", "Dopeul Enutrof", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0523", "Dopeul Féca", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0524", "Dopeul Huppermage", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0525", "Dopeul Iop", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0526", "Dopeul Osamodas", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0527", "Dopeul Ouginak", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0528", "Dopeul Pandawa", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0529", "Dopeul Roublard", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0530", "Dopeul Sacrieur", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0531", "Dopeul Sadida", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0532", "Dopeul Sram", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0533", "Dopeul Steamer", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0533a", "Dopeul Xélor", "CHA-081") != 0) return 1;
		if(insertAchievement("QUE-0533b", "Dopeul Zobal", "CHA-081") != 0) return 1;

		if(insertAchievement("CHA-082", "La Bravade des gens heureux", "SUB-028") != 0) return 1;
		
		if(insertAchievement("QUE-0534", "Challenge Cra (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0535", "Challenge Ecaflip (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0536", "Challenge Eliotrope (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0537", "Challenge Eniripsa (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0538", "Challenge Enutrof (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0539", "Challenge Féca (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0540", "Challenge Huppermage (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0541", "Challenge Iop (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0542", "Challenge Osamodas (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0543", "Challenge Ouginak (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0544", "Challenge Pandawa (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0545", "Challenge Roublard (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0546", "Challenge Sacrieur (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0547", "Challenge Sadida (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0548", "Challenge Sram (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0549", "Challenge Steamer (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0550", "Challenge Xélor (10 challenges)", "CHA-082") != 0) return 1;
		if(insertAchievement("QUE-0551", "Challenge Zobal (10 challenges)", "CHA-082") != 0) return 1;
		
		if(insertAchievement("SUB-029", "Amakna", "SUC-04") != 0) return 1;
		
		if(insertAchievement("CHA-083", "Ils étaient si mignons", "SUB-029") != 0) return 1;
		
		if(insertAchievement("QUE-0552", "Bouftous", "CHA-083") != 0) return 1;
		
		if(insertAchievement("SBQ-0326", "Boufton Blanc", "QUE-0552") != 0) return 1;
		if(insertAchievement("SBQ-0327", "Boufton Noir", "QUE-0552") != 0) return 1;
		if(insertAchievement("SBQ-0328", "Chef de Guerre Bouftou", "QUE-0552") != 0) return 1;
		if(insertAchievement("SBQ-0329", "Bouftou", "QUE-0552") != 0) return 1;
		if(insertAchievement("SBQ-0330", "Bouftou Noir", "QUE-0552") != 0) return 1;
		
		if(insertAchievement("QUE-0553", "Champis", "CHA-083") != 0) return 1;
		
		if(insertAchievement("SBQ-0331", "Champa Bleu", "QUE-0553") != 0) return 1;
		if(insertAchievement("SBQ-0332", "Champa Marron", "QUE-0553") != 0) return 1;
		if(insertAchievement("SBQ-0333", "Champa Rouge", "QUE-0553") != 0) return 1;
		if(insertAchievement("SBQ-0334", "Champa Vert", "QUE-0553") != 0) return 1;
		
		if(insertAchievement("QUE-0554", "Larves", "CHA-083") != 0) return 1;
		
		if(insertAchievement("SBQ-0335", "Larve Bleue", "QUE-0554") != 0) return 1;
		if(insertAchievement("SBQ-0336", "Larve Dorée", "QUE-0554") != 0) return 1;
		if(insertAchievement("SBQ-0337", "Larve Orange", "QUE-0554") != 0) return 1;
		if(insertAchievement("SBQ-0338", "Larve Rubis", "QUE-0554") != 0) return 1;
		if(insertAchievement("SBQ-0339", "Larve Saphir", "QUE-0554") != 0) return 1;
		if(insertAchievement("SBQ-0340", "Larve Verte", "QUE-0554") != 0) return 1;
		if(insertAchievement("SBQ-0341", "Larve Émeraude", "QUE-0554") != 0) return 1;
		
		if(insertAchievement("QUE-0555", "Plantes des champs", "CHA-083") != 0) return 1;
		
		if(insertAchievement("SBQ-0342", "Pissenlit Diabolique", "QUE-0555") != 0) return 1;
		if(insertAchievement("SBQ-0343", "Rose Démoniaque", "QUE-0555") != 0) return 1;
		if(insertAchievement("SBQ-0344", "Rose Obscure", "QUE-0555") != 0) return 1;
		if(insertAchievement("SBQ-0345", "Tournesol Sauvage", "QUE-0555") != 0) return 1;
		if(insertAchievement("SBQ-0346", "Épouvanteur", "QUE-0555") != 0) return 1;
		if(insertAchievement("SBQ-0347", "Gardienne Champêtre", "QUE-0555") != 0) return 1;
		
		if(insertAchievement("QUE-0556", "Tofus", "CHA-083") != 0) return 1;
		
		if(insertAchievement("SBQ-0348", "Tofoune", "QUE-0556") != 0) return 1;
		if(insertAchievement("SBQ-0349", "Tofu Noir", "QUE-0556") != 0) return 1;
		if(insertAchievement("SBQ-0350", "Tofu Ventripotent", "QUE-0556") != 0) return 1;
		if(insertAchievement("SBQ-0351", "Tofukaz", "QUE-0556") != 0) return 1;
		if(insertAchievement("SBQ-0352", "Tofu", "QUE-0556") != 0) return 1;
		if(insertAchievement("SBQ-0353", "Tofu Mutant", "QUE-0556") != 0) return 1;

		if(insertAchievement("QUE-0557", "Plagistes", "CHA-083") != 0) return 1;
		
		if(insertAchievement("SBQ-0354", "Crabe", "QUE-0557") != 0) return 1;
		if(insertAchievement("SBQ-0355", "Pichon Blanc", "QUE-0557") != 0) return 1;
		if(insertAchievement("SBQ-0356", "Pichon Bleu", "QUE-0557") != 0) return 1;
		if(insertAchievement("SBQ-0357", "Pichon Kloune", "QUE-0557") != 0) return 1;
		if(insertAchievement("SBQ-0358", "Pichon Orange", "QUE-0557") != 0) return 1;
		if(insertAchievement("SBQ-0359", "Pichon Vert", "QUE-0557") != 0) return 1;
		if(insertAchievement("SBQ-0360", "Raul Mops", "QUE-0557") != 0) return 1;
		if(insertAchievement("SBQ-0361", "Étoile de la Mer d''Asse", "QUE-0557") != 0) return 1;
		
		if(insertAchievement("QUE-0558", "Pious", "CHA-083") != 0) return 1;
		
		if(insertAchievement("SBQ-0362", "Piou Bleu", "QUE-0558") != 0) return 1;
		if(insertAchievement("SBQ-0363", "Piou Jaune", "QUE-0558") != 0) return 1;
		if(insertAchievement("SBQ-0364", "Piou Rose", "QUE-0558") != 0) return 1;
		if(insertAchievement("SBQ-0365", "Piou Rouge", "QUE-0558") != 0) return 1;
		if(insertAchievement("SBQ-0366", "Piou Vert", "QUE-0558") != 0) return 1;
		if(insertAchievement("SBQ-0367", "Piou Violet", "QUE-0558") != 0) return 1;
		
		if(insertAchievement("QUE-0559", "Animaux de la forêt", "CHA-083") != 0) return 1;
		
		if(insertAchievement("SBQ-0368", "Écurouille", "QUE-0559") != 0) return 1;
		if(insertAchievement("SBQ-0369", "Milimulou", "QUE-0559") != 0) return 1;
		if(insertAchievement("SBQ-0370", "Prespic", "QUE-0559") != 0) return 1;
		if(insertAchievement("SBQ-0371", "Sanglier", "QUE-0559") != 0) return 1;
		
		if(insertAchievement("QUE-0560", "Animalades", "CHA-083") != 0) return 1;
		
		if(insertAchievement("SBQ-0372", "Arakmuté", "QUE-0560") != 0) return 1;
		if(insertAchievement("SBQ-0373", "Arakne Malade", "QUE-0560") != 0) return 1;
		if(insertAchievement("SBQ-0374", "Araknosé", "QUE-0560") != 0) return 1;
		if(insertAchievement("SBQ-0375", "Tofu Malade", "QUE-0560") != 0) return 1;
		
		if(insertAchievement("QUE-0561", "Vermines des champs", "CHA-083") != 0) return 1;
		
		if(insertAchievement("SBQ-0376", "Arakne", "QUE-0561") != 0) return 1;
		if(insertAchievement("SBQ-0377", "Campagnoll", "QUE-0561") != 0) return 1;
		if(insertAchievement("SBQ-0378", "Champ Champ", "QUE-0561") != 0) return 1;
		if(insertAchievement("SBQ-0379", "Moskito", "QUE-0561") != 0) return 1;
		
		if(insertAchievement("CHA-084", "En plein vol", "SUB-029") != 0) return 1;
		
		if(insertAchievement("QUE-0562", "Bwaks", "CHA-084") != 0) return 1;
		
		if(insertAchievement("SBQ-0380", "Bwak de Flamme", "QUE-0562") != 0) return 1;
		if(insertAchievement("SBQ-0381", "Bwak de Glace", "QUE-0562") != 0) return 1;
		if(insertAchievement("SBQ-0382", "Bwak de Terre", "QUE-0562") != 0) return 1;
		if(insertAchievement("SBQ-0383", "Bwak de Vent", "QUE-0562") != 0) return 1;

		if(insertAchievement("QUE-0563", "Kwaks", "CHA-084") != 0) return 1;
		
		if(insertAchievement("SBQ-0384", "Kwak de Flamme", "QUE-0563") != 0) return 1;
		if(insertAchievement("SBQ-0385", "Kwak de Glace", "QUE-0563") != 0) return 1;
		if(insertAchievement("SBQ-0386", "Kwak de Terre", "QUE-0563") != 0) return 1;
		if(insertAchievement("SBQ-0387", "Kwak de Vent", "QUE-0563") != 0) return 1;
		
		if(insertAchievement("QUE-0564", "Kwakeres", "CHA-084") != 0) return 1;

		if(insertAchievement("SBQ-0388", "Kwakere de Fkamme", "QUE-0564") != 0) return 1;
		if(insertAchievement("SBQ-0389", "Kwakere de Glace", "QUE-0564") != 0) return 1;
		if(insertAchievement("SBQ-0390", "Kwakere de Terre", "QUE-0564") != 0) return 1;
		if(insertAchievement("SBQ-0391", "Kwakere de Vent", "QUE-0564") != 0) return 1;
		if(insertAchievement("SBQ-0392", "Kwakere de Flamme Protecteur", "QUE-0564") != 0) return 1;
		if(insertAchievement("SBQ-0393", "Kwakere de Glace Protecteur", "QUE-0564") != 0) return 1;
		if(insertAchievement("SBQ-0394", "Kwakere de Terre Protecteur", "QUE-0564") != 0) return 1;
		if(insertAchievement("SBQ-0395", "Kwakere de Vent Protecteur", "QUE-0564") != 0) return 1;
		
		if(insertAchievement("CHA-085", "Ma culotte n''est pas mouillée", "SUB-029") != 0) return 1;
		
		if(insertAchievement("QUE-0565", "Araknes", "CHA-085") != 0) return 1;
		
		if(insertAchievement("SBQ-0395a", "Arakne Agressive", "QUE-0565") != 0) return 1;
		if(insertAchievement("SBQ-0396", "Arakne Majeure", "QUE-0565") != 0) return 1;
		if(insertAchievement("SBQ-0397", "Gardienne des Égouts", "QUE-0565") != 0) return 1;
		
		if(insertAchievement("QUE-0566", "Chafers", "CHA-085") != 0) return 1;
		
		if(insertAchievement("SBQ-0398", "Chafer", "QUE-0566") != 0) return 1;
		if(insertAchievement("SBQ-0399", "Chafer Archer", "QUE-0566") != 0) return 1;
		if(insertAchievement("SBQ-0400", "Chafer d''Élite", "QUE-0566") != 0) return 1;
		if(insertAchievement("SBQ-0401", "Chafer Draugr", "QUE-0566") != 0) return 1;
		if(insertAchievement("SBQ-0402", "Chafer Fantassin", "QUE-0566") != 0) return 1;
		if(insertAchievement("SBQ-0403", "Chafer Invisible", "QUE-0566") != 0) return 1;
		if(insertAchievement("SBQ-0404", "Chafer Lancier", "QUE-0566") != 0) return 1;
		if(insertAchievement("SBQ-0405", "Chafer Primitif", "QUE-0566") != 0) return 1;
		if(insertAchievement("SBQ-0406", "Rib", "QUE-0566") != 0) return 1;
		
		if(insertAchievement("QUE-0567", "Fantômes", "CHA-085") != 0) return 1;
		
		if(insertAchievement("SBQ-0407", "Fantôme Apero", "QUE-0567") != 0) return 1;
		if(insertAchievement("SBQ-0408", "Fantôme Aux Plates", "QUE-0567") != 0) return 1;
		if(insertAchievement("SBQ-0409", "Fantôme Hicide", "QUE-0567") != 0) return 1;
		if(insertAchievement("SBQ-0410", "Fantôme Égérie", "QUE-0567") != 0) return 1;
		
		if(insertAchievement("QUE-0568", "Bestioles de la nuit", "CHA-085") != 0) return 1;
		
		if(insertAchievement("SBQ-0411", "Citwouille", "QUE-0568") != 0) return 1;
		if(insertAchievement("SBQ-0412", "Gargouille", "QUE-0568") != 0) return 1;
		if(insertAchievement("SBQ-0413", "Kwoan", "QUE-0568") != 0) return 1;
		if(insertAchievement("SBQ-0414", "La Ouassingue", "QUE-0568") != 0) return 1;
		if(insertAchievement("SBQ-0415", "Le Ouassingue", "QUE-0568") != 0) return 1;
		if(insertAchievement("SBQ-0416", "Maître Vampire", "QUE-0568") != 0) return 1;
		if(insertAchievement("SBQ-0417", "Noeul", "QUE-0568") != 0) return 1;
		if(insertAchievement("SBQ-0418", "Oni", "QUE-0568") != 0) return 1;
		if(insertAchievement("SBQ-0419", "Souris Grise", "QUE-0568") != 0) return 1;
		if(insertAchievement("SBQ-0420", "Sousouris", "QUE-0568") != 0) return 1;
		if(insertAchievement("SBQ-0421", "Tofu Maléfique", "QUE-0568") != 0) return 1;
		if(insertAchievement("SBQ-0422", "Vampire", "QUE-0568") != 0) return 1;
		
		if(insertAchievement("CHA-086", "Ils l''ont bien mérité", "SUB-029") != 0) return 1;
		
		if(insertAchievement("QUE-0569", "Wabbits", "CHA-086") != 0) return 1;
		
		if(insertAchievement("SBQ-0423", "Black Twabbit", "QUE-0569") != 0) return 1;
		if(insertAchievement("SBQ-0424", "Black Wabbit", "QUE-0569") != 0) return 1;
		if(insertAchievement("SBQ-0425", "Grand Pa Wabbit", "QUE-0569") != 0) return 1;
		if(insertAchievement("SBQ-0426", "Tiwabbit", "QUE-0569") != 0) return 1;
		if(insertAchievement("SBQ-0427", "Tiwabbit Kiafin", "QUE-0569") != 0) return 1;
		if(insertAchievement("SBQ-0428", "Wabbit", "QUE-0569") != 0) return 1;
		if(insertAchievement("SBQ-0429", "Wabbit Gm", "QUE-0569") != 0) return 1;
		if(insertAchievement("SBQ-0430", "Wabbit Squelette", "QUE-0569") != 0) return 1;
		if(insertAchievement("SBQ-0431", "Wo Wabbit", "QUE-0569") != 0) return 1;
		if(insertAchievement("SBQ-0432", "Black Wabbit Squelette", "QUE-0569") != 0) return 1;
		
		if(insertAchievement("QUE-0570", "Minos", "CHA-086") != 0) return 1;
		
		if(insertAchievement("SBQ-0433", "Gamino", "QUE-0570") != 0) return 1;
		if(insertAchievement("SBQ-0434", "Déminoboule", "QUE-0570") != 0) return 1;
		if(insertAchievement("SBQ-0435", "Kraméléhon", "QUE-0570") != 0) return 1;
		if(insertAchievement("SBQ-0436", "Mandrine", "QUE-0570") != 0) return 1;
		if(insertAchievement("SBQ-0437", "Minoskito", "QUE-0570") != 0) return 1;
		if(insertAchievement("SBQ-0438", "Mominotor", "QUE-0570") != 0) return 1;
		if(insertAchievement("SBQ-0439", "Scaratos", "QUE-0570") != 0) return 1;
		if(insertAchievement("SBQ-0440", "Serpiplume", "QUE-0570") != 0) return 1;
		
		if(insertAchievement("QUE-0571", "Abraknydiens", "CHA-086") != 0) return 1;
		
		if(insertAchievement("SBQ-0441", "Abrakne", "QUE-0571") != 0) return 1;
		if(insertAchievement("SBQ-0442", "Abraknyde", "QUE-0571") != 0) return 1;
		if(insertAchievement("SBQ-0443", "Abraknyde Chétif", "QUE-0571") != 0) return 1;
		if(insertAchievement("SBQ-0444", "Tronknyde", "QUE-0571") != 0) return 1;
		
		if(insertAchievement("QUE-0572", "Gelées", "CHA-086") != 0) return 1;
		
		if(insertAchievement("SBQ-0445", "Gelée Bleue", "QUE-0572") != 0) return 1;
		if(insertAchievement("SBQ-0446", "Gelée Citron", "QUE-0572") != 0) return 1;
		if(insertAchievement("SBQ-0447", "Gelée Fraise", "QUE-0572") != 0) return 1;
		if(insertAchievement("SBQ-0448", "Gelée Menthe", "QUE-0572") != 0) return 1;
		
		if(insertAchievement("QUE-0573", "Mulous", "CHA-086") != 0) return 1;
		
		if(insertAchievement("SBQ-0449", "Mulou", "QUE-0573") != 0) return 1;
		if(insertAchievement("SBQ-0450", "Cocholou", "QUE-0573") != 0) return 1;
		if(insertAchievement("SBQ-0451", "Mulounoké", "QUE-0573") != 0) return 1;
		if(insertAchievement("SBQ-0452", "Mergranlou", "QUE-0573") != 0) return 1;
		if(insertAchievement("SBQ-0453", "Muloubard", "QUE-0573") != 0) return 1;
		
		if(insertAchievement("QUE-0574", "Scarafeuilles", "CHA-086") != 0) return 1;
		
		if(insertAchievement("SBQ-0454", "Flammèche Air", "QUE-0574") != 0) return 1;
		if(insertAchievement("SBQ-0455", "Flammèche Eau", "QUE-0574") != 0) return 1;
		if(insertAchievement("SBQ-0456", "Flammèche Feu", "QUE-0574") != 0) return 1;
		if(insertAchievement("SBQ-0457", "Flammèche Terre", "QUE-0574") != 0) return 1;
		if(insertAchievement("SBQ-0458", "Scarafeuille Blanc", "QUE-0574") != 0) return 1;
		if(insertAchievement("SBQ-0459", "Scarafeuille Bleu", "QUE-0574") != 0) return 1;
		if(insertAchievement("SBQ-0460", "Scarafeuille Immature", "QUE-0574") != 0) return 1;
		if(insertAchievement("SBQ-0461", "Scarafeuille Noir", "QUE-0574") != 0) return 1;
		if(insertAchievement("SBQ-0462", "Scarafeuille Rouge", "QUE-0574") != 0) return 1;
		if(insertAchievement("SBQ-0463", "Scarafeuille Vert", "QUE-0574") != 0) return 1;
		
		if(insertAchievement("QUE-0575", "Craqueleurs", "CHA-086") != 0) return 1;
		
		if(insertAchievement("SBQ-0464", "Craquebille", "QUE-0575") != 0) return 1;
		if(insertAchievement("SBQ-0465", "Craqueboule", "QUE-0575") != 0) return 1;
		if(insertAchievement("SBQ-0466", "Craqueleur", "QUE-0575") != 0) return 1;
		if(insertAchievement("SBQ-0467", "Craqueleur des plaines", "QUE-0575") != 0) return 1;
		if(insertAchievement("SBQ-0468", "Élémenterre", "QUE-0575") != 0) return 1;
		if(insertAchievement("SBQ-0469", "Craquelourd", "QUE-0575") != 0) return 1;
		if(insertAchievement("SBQ-0470", "Craquelope", "QUE-0575") != 0) return 1;
		
		if(insertAchievement("QUE-0576", "Blops", "CHA-086") != 0) return 1;
		
		if(insertAchievement("SBQ-0471", "Biblop Coco", "QUE-0576") != 0) return 1;
		if(insertAchievement("SBQ-0472", "Biblop Griotte", "QUE-0576") != 0) return 1;
		if(insertAchievement("SBQ-0473", "Biblop Indigo", "QUE-0576") != 0) return 1;
		if(insertAchievement("SBQ-0474", "Biblop Reinette", "QUE-0576") != 0) return 1;
		if(insertAchievement("SBQ-0475", "Blop Coco", "QUE-0576") != 0) return 1;
		if(insertAchievement("SBQ-0476", "Blop Griotte", "QUE-0576") != 0) return 1;
		if(insertAchievement("SBQ-0477", "Blop Indigo", "QUE-0576") != 0) return 1;
		if(insertAchievement("SBQ-0478", "Blop Reinette", "QUE-0576") != 0) return 1;
		if(insertAchievement("SBQ-0479", "Blopignon", "QUE-0576") != 0) return 1;
		if(insertAchievement("SBQ-0480", "Gloutoblop", "QUE-0576") != 0) return 1;
		if(insertAchievement("SBQ-0481", "Tronkoblop", "QUE-0576") != 0) return 1;
		
		if(insertAchievement("QUE-0577", "Rats malades", "CHA-086") != 0) return 1;
		
		if(insertAchievement("SBQ-0482", "Chamane d''Égoutant malade", "QUE-0577") != 0) return 1;
		if(insertAchievement("SBQ-0483", "Milirat d''Égoutant malade", "QUE-0577") != 0) return 1;
		if(insertAchievement("SBQ-0483a", "Rat d''Égoutant malade", "QUE-0577") != 0) return 1;
		
		if(insertAchievement("QUE-0578", "Abraknydiens Sombres", "CHA-086") != 0) return 1;
		
		if(insertAchievement("SBQ-0484", "Abrakne Sombre", "QUE-0578") != 0) return 1;
		if(insertAchievement("SBQ-0485", "Abraknyde Sombre", "QUE-0578") != 0) return 1;
		if(insertAchievement("SBQ-0486", "Abraknyde Vénérable", "QUE-0578") != 0) return 1;
		if(insertAchievement("SBQ-0487", "Araknotron", "QUE-0578") != 0) return 1;
		
		if(insertAchievement("QUE-0579", "Abraknydiens Irascibles", "CHA-086") != 0) return 1;
		
		if(insertAchievement("SBQ-0488", "Abrakne Sombre Irascible", "QUE-0579") != 0) return 1;
		if(insertAchievement("SBQ-0489", "Abraknyde Sombre Irascible", "QUE-0579") != 0) return 1;
		if(insertAchievement("SBQ-0490", "Araknotron Irascible", "QUE-0579") != 0) return 1;
		if(insertAchievement("SBQ-0491", "Branche Soignante", "QUE-0579") != 0) return 1;
		if(insertAchievement("SBQ-0492", "Branche Invocatrice", "QUE-0579") != 0) return 1;
		
		if(insertAchievement("QUE-0580", "Gawdes du Wa", "CHA-086") != 0) return 1;

		if(insertAchievement("SBQ-0493", "Black Wo Wabbit", "QUE-0580") != 0) return 1;
		if(insertAchievement("SBQ-0494", "Wobot Kiafin", "QUE-0580") != 0) return 1;
		if(insertAchievement("SBQ-0495", "Blanc Pa Wabbit", "QUE-0580") != 0) return 1;
		if(insertAchievement("SBQ-0496", "Tiwobot", "QUE-0580") != 0) return 1;
		if(insertAchievement("SBQ-0497", "Wobot", "QUE-0580") != 0) return 1;
		
		if(insertAchievement("CHA-087", "Amateur de Kaliptus", "SUB-029") != 0) return 1;
		
		if(insertAchievement("QUE-0581", "Koalaks", "CHA-087") != 0) return 1;
		
		if(insertAchievement("SBQ-0498", "Dok Alako", "QUE-0581") != 0) return 1;
		if(insertAchievement("SBQ-0499", "Drakoalak", "QUE-0581") != 0) return 1;
		if(insertAchievement("SBQ-0500", "Koalak Coco", "QUE-0581") != 0) return 1;
		if(insertAchievement("SBQ-0501", "Koalak Griotte", "QUE-0581") != 0) return 1;
		if(insertAchievement("SBQ-0502", "Koalak Indigo", "QUE-0581") != 0) return 1;
		if(insertAchievement("SBQ-0503", "Koalak Reinette", "QUE-0581") != 0) return 1;
		if(insertAchievement("SBQ-0504", "Mama Koalak", "QUE-0581") != 0) return 1;
		if(insertAchievement("SBQ-0505", "Warko Marron", "QUE-0581") != 0) return 1;
		
		if(insertAchievement("QUE-0582", "Boufcools", "CHA-087") != 0) return 1;
		
		if(insertAchievement("SBQ-0506", "Boufcoul", "QUE-0582") != 0) return 1;
		if(insertAchievement("SBQ-0507", "Bouftou des Cavernes", "QUE-0582") != 0) return 1;
		
		if(insertAchievement("QUE-0583", "Dragodindes", "CHA-087") != 0) return 1;
		
		if(insertAchievement("SBQ-0508", "Dragodinde Amande Sauvage", "QUE-0583") != 0) return 1;
		if(insertAchievement("SBQ-0509", "Dragodinde Dorée Sauvage", "QUE-0583") != 0) return 1;
		if(insertAchievement("SBQ-0510", "Dragodinde Rousse Sauvage", "QUE-0583") != 0) return 1;
		if(insertAchievement("SBQ-0511", "Dragodinde Fiévreuse Sauvage", "QUE-0583") != 0) return 1;
		
		if(insertAchievement("QUE-0584", "Koalaks primitifs", "CHA-087") != 0) return 1;
		
		if(insertAchievement("SBQ-0512", "Chevaucheur Koalak", "QUE-0584") != 0) return 1;
		if(insertAchievement("SBQ-0513", "Fossoyeur Kolak", "QUE-0584") != 0) return 1;
		if(insertAchievement("SBQ-0514", "Maître Koalak", "QUE-0584") != 0) return 1;
		if(insertAchievement("SBQ-0515", "Momie Koalak", "QUE-0584") != 0) return 1;
		
		if(insertAchievement("QUE-0585", "Koalaks mortels", "CHA-087") != 0) return 1;
		
		if(insertAchievement("SBQ-0516", "Fauchalak", "QUE-0585") != 0) return 1;
		if(insertAchievement("SBQ-0517", "Guerrier Koalak", "QUE-0585") != 0) return 1;
		if(insertAchievement("SBQ-0518", "Koalak Farouche", "QUE-0585") != 0) return 1;
		if(insertAchievement("SBQ-0519", "Koalak Forestier", "QUE-0585") != 0) return 1;
		if(insertAchievement("SBQ-0520", "Koalak Immature", "QUE-0585") != 0) return 1;
		if(insertAchievement("SBQ-0521", "Koalak Sanguin", "QUE-0585") != 0) return 1;
		if(insertAchievement("SBQ-0522", "Piralak", "QUE-0585") != 0) return 1;
		if(insertAchievement("SBQ-0523", "Pékeualak", "QUE-0585") != 0) return 1;
		if(insertAchievement("SBQ-0524", "Warko Violet", "QUE-0585") != 0) return 1;
		
		if(insertAchievement("CHA-088", "Sans casser d''oeufs", "SUB-029") != 0) return 1;
		
		if(insertAchievement("QUE-0586", "Dragoeufs", "CHA-088") != 0) return 1;
		
		if(insertAchievement("SBQ-0525", "Coquille Explosive", "QUE-0586") != 0) return 1;
		if(insertAchievement("SBQ-0526", "DragOeuf Blanc", "QUE-0586") != 0) return 1;
		if(insertAchievement("SBQ-0527", "DragOeuf Blanc Immature", "QUE-0586") != 0) return 1;
		if(insertAchievement("SBQ-0528", "DragOeuf Blanc Éveillé", "QUE-0586") != 0) return 1;
		if(insertAchievement("SBQ-0529", "DragOeuf de Saphir", "QUE-0586") != 0) return 1;
		if(insertAchievement("SBQ-0530", "DragOeuf de Saphir Immature", "QUE-0586") != 0) return 1;
		if(insertAchievement("SBQ-0530a", "DragOeuf de Saphir Éveillé", "QUE-0586") != 0) return 1;
		if(insertAchievement("SBQ-0531", "DragOeuf Doré", "QUE-0586") != 0) return 1;
		if(insertAchievement("SBQ-0532", "DragOeuf Doré Immature", "QUE-0586") != 0) return 1;
		if(insertAchievement("SBQ-0533", "DragOeuf Doré Éveillé", "QUE-0586") != 0) return 1;
		if(insertAchievement("SBQ-0534", "DragOeuf Noir", "QUE-0586") != 0) return 1;
		if(insertAchievement("SBQ-0535", "DragOeuf Noir Immature", "QUE-0586") != 0) return 1;
		if(insertAchievement("SBQ-0536", "DragOeuf Noir Éveillé", "QUE-0586") != 0) return 1;
		
		if(insertAchievement("QUE-0587", "Dragoeufs du Sanctuaire", "CHA-088") != 0) return 1;
		
		if(insertAchievement("SBQ-0537", "Dragoeuf Volant", "QUE-0587") != 0) return 1;
		if(insertAchievement("SBQ-0538", "Dragoss Blanc", "QUE-0587") != 0) return 1;
		if(insertAchievement("SBQ-0539", "Dragoss Blanc Éveillé", "QUE-0587") != 0) return 1;
		if(insertAchievement("SBQ-0540", "Dragoss de Saphir", "QUE-0587") != 0) return 1;
		if(insertAchievement("SBQ-0541", "Dragoss de Saphir Éveillé", "QUE-0587") != 0) return 1;
		if(insertAchievement("SBQ-0542", "Dragoss Doré", "QUE-0587") != 0) return 1;
		if(insertAchievement("SBQ-0543", "Dragoss Doré Éveillé", "QUE-0587") != 0) return 1;
		if(insertAchievement("SBQ-0544", "Dragoss Noir", "QUE-0587") != 0) return 1;
		if(insertAchievement("SBQ-0545", "Dragoss Noir Éveillé", "QUE-0587") != 0) return 1;
		if(insertAchievement("SBQ-0546", "Dragueuse", "QUE-0587") != 0) return 1;
		if(insertAchievement("SBQ-0547", "Dragoeuf Guerrier", "QUE-0587") != 0) return 1;
		
		if(insertAchievement("QUE-0588", "Dragoeufs nommés", "CHA-088") != 0) return 1;

		if(insertAchievement("SBQ-0548", "Aerohouctor le Guerrier", "QUE-0588") != 0) return 1;
		if(insertAchievement("SBQ-0549", "Aerotrugobur le Malveillant", "QUE-0588") != 0) return 1;
		if(insertAchievement("SBQ-0550", "Aquabralak le Guerrier", "QUE-0588") != 0) return 1;
		if(insertAchievement("SBQ-0551", "Aqualikros l''Impitoyable", "QUE-0588") != 0) return 1;
		if(insertAchievement("SBQ-0552", "Ignelicrobur le Guerrier", "QUE-0588") != 0) return 1;
		if(insertAchievement("SBQ-0553", "Ignerkocropos l''Affamé", "QUE-0588") != 0) return 1;
		if(insertAchievement("SBQ-0554", "Terraburkal le Perfide", "QUE-0588") != 0) return 1;
		if(insertAchievement("SBQ-0555", "Terrakoubiak le Guerrier", "QUE-0588") != 0) return 1;
		
		if(insertAchievement("CHA-089", "Les intellectuels", "SUB-029") != 0) return 1;
		
		if(insertAchievement("QUE-0589", "Bworks", "CHA-089") != 0) return 1;
		
		if(insertAchievement("SBQ-0556", "Bwork", "QUE-0589") != 0) return 1;
		if(insertAchievement("SBQ-0557", "Bwork Archer", "QUE-0589") != 0) return 1;
		if(insertAchievement("SBQ-0558", "Bwork Mage", "QUE-0589") != 0) return 1;

		if(insertAchievement("QUE-0590", "Gros Bworks", "CHA-089") != 0) return 1;
		
		if(insertAchievement("SBQ-0559", "Bwork Élémental d''Air", "QUE-0590") != 0) return 1;
		if(insertAchievement("SBQ-0560", "Bwork Élémental d''Eau", "QUE-0590") != 0) return 1;
		if(insertAchievement("SBQ-0561", "Bwork Élémental de Feu", "QUE-0590") != 0) return 1;
		if(insertAchievement("SBQ-0562", "Bwork Élémental de Terre", "QUE-0590") != 0) return 1;
		if(insertAchievement("SBQ-0563", "Cybwork", "QUE-0590") != 0) return 1;
		if(insertAchievement("SBQ-0564", "Mama Bwork", "QUE-0590") != 0) return 1;
		
		if(insertAchievement("QUE-0591", "Porcos", "CHA-089") != 0) return 1;
		
		if(insertAchievement("SBQ-0565", "Cochon de Farle", "QUE-0591") != 0) return 1;
		if(insertAchievement("SBQ-0566", "Don Dorgan", "QUE-0591") != 0) return 1;
		if(insertAchievement("SBQ-0567", "Don Duss Ang", "QUE-0591") != 0) return 1;
		if(insertAchievement("SBQ-0568", "Porsalu", "QUE-0591") != 0) return 1;
		
		if(insertAchievement("QUE-0592", "Gobelins", "CHA-089") != 0) return 1;
		
		if(insertAchievement("SBQ-0569", "Gobelin", "QUE-0592") != 0) return 1;
		if(insertAchievement("SBQ-0570", "Chevaucheur de Karne", "QUE-0592") != 0) return 1;
		
		if(insertAchievement("QUE-0593", "Porkass", "CHA-089") != 0) return 1;
		
		if(insertAchievement("SBQ-0571", "Berger Porkass", "QUE-0593") != 0) return 1;
		if(insertAchievement("SBQ-0572", "Cavalier Porkass", "QUE-0593") != 0) return 1;
		if(insertAchievement("SBQ-0573", "Sanglier des Plaines", "QUE-0593") != 0) return 1;
		if(insertAchievement("SBQ-0574", "Cochon de Lait", "QUE-0593") != 0) return 1;
		
		if(insertAchievement("CHA-090", "C''est eux qui ont commencé", "SUB-029") != 0) return 1;
		
		if(insertAchievement("QUE-0594", "Fungus", "CHA-090") != 0) return 1;
		
		if(insertAchievement("SBQ-0575", "Champ à Gnons", "QUE-0594") != 0) return 1;
		if(insertAchievement("SBQ-0576", "Champaknyde", "QUE-0594") != 0) return 1;
		if(insertAchievement("SBQ-0577", "Champbis", "QUE-0594") != 0) return 1;
		if(insertAchievement("SBQ-0578", "Champmane", "QUE-0594") != 0) return 1;
		if(insertAchievement("SBQ-0579", "Champodonte", "QUE-0594") != 0) return 1;
		if(insertAchievement("SBQ-0580", "Tromperelle", "QUE-0594") != 0) return 1;

		if(insertAchievement("QUE-0595", "Gros Tofus", "CHA-090") != 0) return 1;
		
		if(insertAchievement("SBQ-0581", "Tofu Dodu", "QUE-0595") != 0) return 1;
		if(insertAchievement("SBQ-0582", "Tofubine", "QUE-0595") != 0) return 1;
		if(insertAchievement("SBQ-0583", "Tofutoflamme", "QUE-0595") != 0) return 1;
		if(insertAchievement("SBQ-0584", "Tofuzmo", "QUE-0595") != 0) return 1;
		if(insertAchievement("SBQ-0585", "Vilain Petit Tofu", "QUE-0595") != 0) return 1;
		
		if(insertAchievement("QUE-0596", "Sidimonstres", "CHA-090") != 0) return 1;
		
		if(insertAchievement("SBQ-0586", "Croc Gland", "QUE-0596") != 0) return 1;
		if(insertAchievement("SBQ-0587", "Kolérat", "QUE-0596") != 0) return 1;
		if(insertAchievement("SBQ-0588", "Macien", "QUE-0596") != 0) return 1;
		if(insertAchievement("SBQ-0589", "Scorbute", "QUE-0596") != 0) return 1;
		if(insertAchievement("SBQ-0590", "Crowneille", "QUE-0596") != 0) return 1;

		if(insertAchievement("QUE-0597", "Gadouilleux", "CHA-090") != 0) return 1;
		
		if(insertAchievement("SBQ-0591", "Chef Crocodaille", "QUE-0597") != 0) return 1;
		if(insertAchievement("SBQ-0592", "Crocodaille", "QUE-0597") != 0) return 1;
		if(insertAchievement("SBQ-0593", "Boo", "QUE-0597") != 0) return 1;
		if(insertAchievement("SBQ-0594", "Arakne Olithique", "QUE-0597") != 0) return 1;

		if(insertAchievement("QUE-0598", "Corbacs", "CHA-090") != 0) return 1;
		
		if(insertAchievement("SBQ-0595", "Corbac Apprivoisé", "QUE-0598") != 0) return 1;
		if(insertAchievement("SBQ-0596", "Buveur", "QUE-0598") != 0) return 1;
		if(insertAchievement("SBQ-0597", "Corbac", "QUE-0598") != 0) return 1;
		if(insertAchievement("SBQ-0598", "Horace le Corbac Apprivoisé", "QUE-0598") != 0) return 1;
		if(insertAchievement("SBQ-0599", "Kapotie le Buveur", "QUE-0598") != 0) return 1;
		if(insertAchievement("SBQ-0600", "Renarbo", "QUE-0598") != 0) return 1;
		if(insertAchievement("SBQ-0601", "Rono le Renarbo", "QUE-0598") != 0) return 1;
		if(insertAchievement("SBQ-0602", "Capsaaloocke", "QUE-0598") != 0) return 1;
		
		if(insertAchievement("QUE-0599", "Animaux des Champs", "CHA-090") != 0) return 1;
		
		if(insertAchievement("SBQ-0603", "Bourdard", "QUE-0599") != 0) return 1;
		if(insertAchievement("SBQ-0604", "Larve Champêtre", "QUE-0599") != 0) return 1;
		if(insertAchievement("SBQ-0605", "Serpentin", "QUE-0599") != 0) return 1;
		if(insertAchievement("SBQ-0606", "Souris Verte", "QUE-0599") != 0) return 1;
		
		if(insertAchievement("QUE-0600", "Rats", "CHA-090") != 0) return 1;
		
		if(insertAchievement("SBQ-0607", "Chamane d''Égoutant", "QUE-0600") != 0) return 1;
		if(insertAchievement("SBQ-0608", "Rat Bajoie", "QUE-0600") != 0) return 1;
		if(insertAchievement("SBQ-0609", "Rat Basher", "QUE-0600") != 0) return 1;
		if(insertAchievement("SBQ-0610", "Rat Batteur", "QUE-0600") != 0) return 1;
		if(insertAchievement("SBQ-0611", "Rat Croc", "QUE-0600") != 0) return 1;
		if(insertAchievement("SBQ-0612", "Rat d''Hyoactif", "QUE-0600") != 0) return 1;
		if(insertAchievement("SBQ-0613", "Rat d''Égoutant", "QUE-0600") != 0) return 1;
		if(insertAchievement("SBQ-0614", "Rat de Marais", "QUE-0600") != 0) return 1;
		if(insertAchievement("SBQ-0615", "Rat Klure", "QUE-0600") != 0) return 1;
		if(insertAchievement("SBQ-0616", "Guerrier Mental d''Égoutant", "QUE-0600") != 0) return 1;
		if(insertAchievement("SBQ-0617", "Rat Luisant d''Égoutant", "QUE-0600") != 0) return 1;

		if(insertAchievement("QUE-0601", "Bandits", "CHA-090") != 0) return 1;
		
		if(insertAchievement("SBQ-0618", "Bandit du clan des Roublards", "QUE-0601") != 0) return 1;
		if(insertAchievement("SBQ-0619", "Bandit Manchot", "QUE-0601") != 0) return 1;
		if(insertAchievement("SBQ-0620", "Boulanger Sombre", "QUE-0601") != 0) return 1;
		if(insertAchievement("SBQ-0621", "Forgeron Sombre", "QUE-0601") != 0) return 1;
		if(insertAchievement("SBQ-0622", "Mineur Sombre", "QUE-0601") != 0) return 1;
		
		if(insertAchievement("CHA-091", "J''tape dans l''fond", "SUB-029") != 0) return 1;
		
		if(insertAchievement("QUE-0602", "Mercemers", "CHA-091") != 0) return 1;
		
		if(insertAchievement("SBQ-0623", "Pikoleur", "QUE-0602") != 0) return 1;
		if(insertAchievement("SBQ-0624", "Harpo", "QUE-0602") != 0) return 1;
		if(insertAchievement("SBQ-0625", "Krabouilleur", "QUE-0602") != 0) return 1;
		if(insertAchievement("SBQ-0626", "Eskoglyphe", "QUE-0602") != 0) return 1;
		if(insertAchievement("SBQ-0627", "Cyclophandre", "QUE-0602") != 0) return 1;
		
		if(insertAchievement("QUE-0603", "Monstres des ruines sous-marines", "CHA-091") != 0) return 1;
		
		if(insertAchievement("SBQ-0628", "Mol Usk", "QUE-0603") != 0) return 1;
		if(insertAchievement("SBQ-0629", "Crabe Yoloniste", "QUE-0603") != 0) return 1;
		if(insertAchievement("SBQ-0630", "Gambaf", "QUE-0603") != 0) return 1;
		if(insertAchievement("SBQ-0631", "Mantaze", "QUE-0603") != 0) return 1;
		if(insertAchievement("SBQ-0632", "Tilamproie", "QUE-0603") != 0) return 1;
		
		if(insertAchievement("QUE-0604", "Serviteurs de l''indicible", "CHA-091") != 0) return 1;
		
		if(insertAchievement("SBQ-0633", "Grofond", "QUE-0604") != 0) return 1;
		if(insertAchievement("SBQ-0634", "N''yalg", "QUE-0604") != 0) return 1;
		if(insertAchievement("SBQ-0635", "Shokkoth", "QUE-0604") != 0) return 1;
		if(insertAchievement("SBQ-0636", "Li-Fo", "QUE-0604") != 0) return 1;
		if(insertAchievement("SBQ-0637", "Klûtiste", "QUE-0604") != 0) return 1;
		
		if(insertAchievement("QUE-0605", "Trithons", "CHA-091") != 0) return 1;
		
		if(insertAchievement("SBQ-0638", "Tourthon", "QUE-0605") != 0) return 1;
		if(insertAchievement("SBQ-0639", "Poulpée", "QUE-0605") != 0) return 1;
		if(insertAchievement("SBQ-0640", "Tryde", "QUE-0605") != 0) return 1;
		if(insertAchievement("SBQ-0641", "Rilur", "QUE-0605") != 0) return 1;
		if(insertAchievement("SBQ-0642", "Diondin", "QUE-0605") != 0) return 1;

		if(insertAchievement("CHA-092", "Autres", "SUB-029") != 0) return 1;
		
		if(insertAchievement("QUE-0606", "Vilinsekts", "CHA-092") != 0) return 1;
		
		if(insertAchievement("SBQ-0643", "Cafarcher", "QUE-0606") != 0) return 1;
		if(insertAchievement("SBQ-0644", "Pyrasite", "QUE-0606") != 0) return 1;
		if(insertAchievement("SBQ-0645", "Mirgrillon", "QUE-0606") != 0) return 1;
		if(insertAchievement("SBQ-0646", "Sakarien", "QUE-0606") != 0) return 1;
		if(insertAchievement("SBQ-0647", "Céglumen", "QUE-0606") != 0) return 1;

		if(insertAchievement("QUE-0607", "Dopeuls", "CHA-092") != 0) return 1;
		
		if(insertAchievement("SBQ-0648", "Aboub", "QUE-0607") != 0) return 1;
		if(insertAchievement("SBQ-0649", "Amlub", "QUE-0607") != 0) return 1;
		if(insertAchievement("SBQ-0650", "Codem", "QUE-0607") != 0) return 1;
		if(insertAchievement("SBQ-0651", "Gink", "QUE-0607") != 0) return 1;
		if(insertAchievement("SBQ-0652", "Idernas", "QUE-0607") != 0) return 1;
		if(insertAchievement("SBQ-0653", "Kirevam", "QUE-0607") != 0) return 1;
		if(insertAchievement("SBQ-0654", "Let Emoliug", "QUE-0607") != 0) return 1;
		if(insertAchievement("SBQ-0655", "Nebgib", "QUE-0607") != 0) return 1;
		if(insertAchievement("SBQ-0656", "Nipul", "QUE-0607") != 0) return 1;
		if(insertAchievement("SBQ-0657", "Osurc", "QUE-0607") != 0) return 1;
		if(insertAchievement("SBQ-0658", "Susej", "QUE-0607") != 0) return 1;
		if(insertAchievement("SBQ-0659", "Dopeul Dark Vlad", "QUE-0607") != 0) return 1;
		
		if(insertAchievement("QUE-0608", "Serviteurs de Dramak", "CHA-092") != 0) return 1;
		
		if(insertAchievement("SBQ-0660", "Bouledogre", "QUE-0608") != 0) return 1;
		if(insertAchievement("SBQ-0661", "Gobvious", "QUE-0608") != 0) return 1;
		if(insertAchievement("SBQ-0662", "Molette", "QUE-0608") != 0) return 1;
		if(insertAchievement("SBQ-0663", "Rhinoféroce", "QUE-0608") != 0) return 1;
		if(insertAchievement("SBQ-0664", "Dramak", "QUE-0608") != 0) return 1;

		if(insertAchievement("QUE-0609", "Wabbits mutants", "CHA-092") != 0) return 1;
		
		if(insertAchievement("SBQ-0665", "Wabbit Vampire", "QUE-0609") != 0) return 1;
		if(insertAchievement("SBQ-0666", "Cawotman", "QUE-0609") != 0) return 1;
		if(insertAchievement("SBQ-0667", "Wabbit Fluo", "QUE-0609") != 0) return 1;
		if(insertAchievement("SBQ-0668", "Wabbit Céphale", "QUE-0609") != 0) return 1;
		if(insertAchievement("SBQ-0669", "Wabbit Garou", "QUE-0609") != 0) return 1;
		
		if(insertAchievement("QUE-0610", "Truches", "CHA-092") != 0) return 1;
		
		if(insertAchievement("SBQ-0670", "Gruche", "QUE-0610") != 0) return 1;
		if(insertAchievement("SBQ-0671", "Truchmuche", "QUE-0610") != 0) return 1;
		if(insertAchievement("SBQ-0672", "Truchideur", "QUE-0610") != 0) return 1;
		if(insertAchievement("SBQ-0673", "Truchtine", "QUE-0610") != 0) return 1;
		if(insertAchievement("SBQ-0674", "Truchon", "QUE-0610") != 0) return 1;
		
		if(insertAchievement("QUE-0611", "Kanigs des Dents de Pierre", "CHA-092") != 0) return 1;
		
		if(insertAchievement("SBQ-0675", "Kanihilan", "QUE-0611") != 0) return 1;
		if(insertAchievement("SBQ-0676", "Alhyène", "QUE-0611") != 0) return 1;
		if(insertAchievement("SBQ-0677", "Félygiène", "QUE-0611") != 0) return 1;
		if(insertAchievement("SBQ-0678", "Panthègros", "QUE-0611") != 0) return 1;
		if(insertAchievement("SBQ-0679", "Kaniblou", "QUE-0611") != 0) return 1;
		if(insertAchievement("SBQ-0680", "Orfélin", "QUE-0611") != 0) return 1;
		
		if(insertAchievement("QUE-0612", "Arak-haï", "CHA-092") != 0) return 1;
		
		if(insertAchievement("SBQ-0681", "Arapex", "QUE-0612") != 0) return 1;
		if(insertAchievement("SBQ-0682", "Dardalaine", "QUE-0612") != 0) return 1;
		if(insertAchievement("SBQ-0683", "Néfileuse", "QUE-0612") != 0) return 1;
		if(insertAchievement("SBQ-0684", "Saltik", "QUE-0612") != 0) return 1;
		if(insertAchievement("SBQ-0685", "Gargantûl", "QUE-0612") != 0) return 1;
		
		if(insertAchievement("QUE-0613", "Automates des Brigandins", "CHA-092") != 0) return 1;
		
		if(insertAchievement("SBQ-0686", "Malle Outillée", "QUE-0613") != 0) return 1;
		if(insertAchievement("SBQ-0687", "Robionicle", "QUE-0613") != 0) return 1;
		if(insertAchievement("SBQ-0688", "Robot Fléau", "QUE-0613") != 0) return 1;
		if(insertAchievement("SBQ-0689", "Robot Pousse-Pousse", "QUE-0613") != 0) return 1;

		if(insertAchievement("QUE-0614", "Ruffians de Cania", "CHA-092") != 0) return 1;
		
		if(insertAchievement("SBQ-0690", "Foufayteur", "QUE-0614") != 0) return 1;
		if(insertAchievement("SBQ-0691", "Vétauran", "QUE-0614") != 0) return 1;
		if(insertAchievement("SBQ-0692", "Kanigrou", "QUE-0614") != 0) return 1;
		if(insertAchievement("SBQ-0693", "Maître Bolet", "QUE-0614") != 0) return 1;
		
		if(insertAchievement("QUE-0615", "Bworks de Cania", "CHA-092") != 0) return 1;
		
		if(insertAchievement("SBQ-0694", "Bizarbwork", "QUE-0615") != 0) return 1;
		if(insertAchievement("SBQ-0695", "Krambwork", "QUE-0615") != 0) return 1;
		if(insertAchievement("SBQ-0696", "Médibwork", "QUE-0615") != 0) return 1;
		if(insertAchievement("SBQ-0697", "Mégabwork", "QUE-0615") != 0) return 1;
		
		if(insertAchievement("QUE-0616", "Troolls de Litneg", "CHA-092") != 0) return 1;
		
		if(insertAchievement("SBQ-0699", "Troollaraj", "QUE-0616") != 0) return 1;
		if(insertAchievement("SBQ-0700", "Troolligark", "QUE-0616") != 0) return 1;
		if(insertAchievement("SBQ-0701", "Troollogram", "QUE-0616") != 0) return 1;
		if(insertAchievement("SBQ-0702", "Troolléolé", "QUE-0616") != 0) return 1;

		if(insertAchievement("QUE-0617", "Gliglis", "CHA-092") != 0) return 1;
		
		if(insertAchievement("SBQ-0703", "Gliglidoudur", "QUE-0617") != 0) return 1;
		if(insertAchievement("SBQ-0704", "Gliglitch", "QUE-0617") != 0) return 1;
		if(insertAchievement("SBQ-0705", "Gliglicérin", "QUE-0617") != 0) return 1;
		if(insertAchievement("SBQ-0706", "Gliglibido", "QUE-0617") != 0) return 1;

		if(insertAchievement("QUE-0618", "Chassouilleurs", "CHA-092") != 0) return 1;
		
		if(insertAchievement("SBQ-0707", "Crâmbo", "QUE-0618") != 0) return 1;
		if(insertAchievement("SBQ-0708", "Nemroz", "QUE-0618") != 0) return 1;
		if(insertAchievement("SBQ-0709", "Brokouillon", "QUE-0618") != 0) return 1;
		if(insertAchievement("SBQ-0710", "Chevrothée", "QUE-0618") != 0) return 1;
		if(insertAchievement("SBQ-0711", "Viandargh", "QUE-0618") != 0) return 1;

		if(insertAchievement("QUE-0619", "Magik Riktus", "CHA-092") != 0) return 1;
		
		if(insertAchievement("SBQ-0712", "Graboule", "QUE-0619") != 0) return 1;
		if(insertAchievement("SBQ-0713", "Roukouto", "QUE-0619") != 0) return 1;
		if(insertAchievement("SBQ-0714", "Pirolienne", "QUE-0619") != 0) return 1;
		if(insertAchievement("SBQ-0715", "Tivelo", "QUE-0619") != 0) return 1;
		if(insertAchievement("SBQ-0716", "Bozoteur", "QUE-0619") != 0) return 1;

		if(insertAchievement("QUE-0620", "Goules", "CHA-092") != 0) return 1;
		
		if(insertAchievement("SBQ-0717", "Goulafre", "QUE-0620") != 0) return 1;
		if(insertAchievement("SBQ-0718", "Kérigoule", "QUE-0620") != 0) return 1;
		if(insertAchievement("SBQ-0719", "Pipisteuse", "QUE-0620") != 0) return 1;
		if(insertAchievement("SBQ-0720", "Gouligane", "QUE-0620") != 0) return 1;
		if(insertAchievement("SBQ-0721", "Goultime", "QUE-0620") != 0) return 1;
		
		if(insertAchievement("SUB-030", "Île de Moon", "SUC-04") != 0) return 1;
		
		if(insertAchievement("CHA-093", "Equipage au complet", "SUB-030") != 0) return 1;

		if(insertAchievement("QUE-0621", "Monstres des Plages de Moon", "CHA-093") != 0) return 1;

		if(insertAchievement("SBQ-0722", "Tortue Bleue", "QUE-0621") != 0) return 1;
		if(insertAchievement("SBQ-0723", "Tortue Jaune", "QUE-0621") != 0) return 1;
		if(insertAchievement("SBQ-0724", "Tortue Rouge", "QUE-0621") != 0) return 1;
		if(insertAchievement("SBQ-0725", "Tortue Verte", "QUE-0621") != 0) return 1;
		if(insertAchievement("SBQ-0726", "Nodkoko", "QUE-0621") != 0) return 1;
		if(insertAchievement("SBQ-0727", "Tikoko", "QUE-0621") != 0) return 1;
		if(insertAchievement("SBQ-0728", "Kokoko", "QUE-0621") != 0) return 1;
		if(insertAchievement("SBQ-0729", "Grokoko", "QUE-0621") != 0) return 1;

		if(insertAchievement("QUE-0622", "Monstres de la Jungle Interdite", "CHA-093") != 0) return 1;

		if(insertAchievement("SBQ-0730", "Fourbasse", "QUE-0622") != 0) return 1;
		if(insertAchievement("SBQ-0731", "Gloutovore", "QUE-0622") != 0) return 1;
		if(insertAchievement("SBQ-0732", "Trukikol", "QUE-0622") != 0) return 1;
		if(insertAchievement("SBQ-0733", "Dostrogo", "QUE-0622") != 0) return 1;
		if(insertAchievement("SBQ-0734", "Domoizelle", "QUE-0622") != 0) return 1;

		if(insertAchievement("QUE-0623", "Pirates de Moon", "CHA-093") != 0) return 1;

		if(insertAchievement("SBQ-0735", "Boomba", "QUE-0623") != 0) return 1;
		if(insertAchievement("SBQ-0736", "Canondorf", "QUE-0623") != 0) return 1;
		if(insertAchievement("SBQ-0737", "Nakunbra", "QUE-0623") != 0) return 1;
		if(insertAchievement("SBQ-0738", "Ricanif", "QUE-0623") != 0) return 1;
		if(insertAchievement("SBQ-0739", "Ivremor", "QUE-0623") != 0) return 1;

		if(insertAchievement("QUE-0624", "Kannibouls", "CHA-093") != 0) return 1;

		if(insertAchievement("SBQ-0740", "Kanniboul Ark", "QUE-0624") != 0) return 1;
		if(insertAchievement("SBQ-0741", "Kanniboul Jav", "QUE-0624") != 0) return 1;
		if(insertAchievement("SBQ-0742", "Kanniboul Sarbak", "QUE-0624") != 0) return 1;
		if(insertAchievement("SBQ-0743", "Kanniboul Eth", "QUE-0624") != 0) return 1;
		if(insertAchievement("SBQ-0744", "Kanniboul Tam", "QUE-0624") != 0) return 1;
		
		if(insertAchievement("SUB-031", "Pandala", "SUC-04") != 0) return 1;

		if(insertAchievement("CHA-094", "Coup de bambou", "SUB-031") != 0) return 1;

		if(insertAchievement("QUE-0625", "Plantalas", "CHA-094") != 0) return 1;

		if(insertAchievement("SBQ-0745", "Bambouto", "QUE-0625") != 0) return 1;
		if(insertAchievement("SBQ-0746", "Bambouto Sacré", "QUE-0625") != 0) return 1;
		if(insertAchievement("SBQ-0747", "Bulbambou", "QUE-0625") != 0) return 1;
		if(insertAchievement("SBQ-0748", "Bulbiflore", "QUE-0625") != 0) return 1;
		if(insertAchievement("SBQ-0749", "Bulbig", "QUE-0625") != 0) return 1;
		if(insertAchievement("SBQ-0750", "Bulbuisson", "QUE-0625") != 0) return 1;

		if(insertAchievement("QUE-0626", "Kitsous", "CHA-094") != 0) return 1;

		if(insertAchievement("SBQ-0751", "Kitsou Nae", "QUE-0626") != 0) return 1;
		if(insertAchievement("SBQ-0752", "Kitsou Nakwa", "QUE-0626") != 0) return 1;
		if(insertAchievement("SBQ-0753", "Kitsou Nere", "QUE-0626") != 0) return 1;
		if(insertAchievement("SBQ-0754", "Kitsou Nufeu", "QUE-0626") != 0) return 1;

		if(insertAchievement("QUE-0627", "Pandissidans", "CHA-094") != 0) return 1;

		if(insertAchievement("SBQ-0755", "Guerrier Pandikaze", "QUE-0627") != 0) return 1;
		if(insertAchievement("SBQ-0756", "Pandikaze", "QUE-0627") != 0) return 1;
		if(insertAchievement("SBQ-0757", "Pandikaze Aérien", "QUE-0627") != 0) return 1;
		if(insertAchievement("SBQ-0758", "Pandikaze Vertige", "QUE-0627") != 0) return 1;
		if(insertAchievement("SBQ-0759", "Pandikwakaze", "QUE-0627") != 0) return 1;
		if(insertAchievement("SBQ-0760", "Pandit", "QUE-0627") != 0) return 1;
		if(insertAchievement("SBQ-0761", "Pandore", "QUE-0627") != 0) return 1;
		if(insertAchievement("SBQ-0762", "Pandule", "QUE-0627") != 0) return 1;
		if(insertAchievement("SBQ-0763", "Pandulkaze", "QUE-0627") != 0) return 1;

		if(insertAchievement("QUE-0628", "Firefoux", "CHA-094") != 0) return 1;

		if(insertAchievement("SBQ-0764", "Léopardo", "QUE-0628") != 0) return 1;
		if(insertAchievement("SBQ-0765", "Maho Firefoux", "QUE-0628") != 0) return 1;
		if(insertAchievement("SBQ-0766", "Soryo Firefoux", "QUE-0628") != 0) return 1;
		if(insertAchievement("SBQ-0767", "Touchparak", "QUE-0628") != 0) return 1;
		if(insertAchievement("SBQ-0768", "Yokai Firefoux", "QUE-0628") != 0) return 1;
		if(insertAchievement("SBQ-0769", "Zilla", "QUE-0628") != 0) return 1;

		if(insertAchievement("QUE-0629", "Fantômes de Grobe", "CHA-094") != 0) return 1;

		if(insertAchievement("SBQ-0770", "Fantôme Léopardo", "QUE-0629") != 0) return 1;
		if(insertAchievement("SBQ-0771", "Fantôme Maho Firefoux", "QUE-0629") != 0) return 1;
		if(insertAchievement("SBQ-0772", "Fantôme Pandikaze", "QUE-0629") != 0) return 1;
		if(insertAchievement("SBQ-0773", "Fantôme Pandore", "QUE-0629") != 0) return 1;
		if(insertAchievement("SBQ-0774", "Fantôme Pandule", "QUE-0629") != 0) return 1;
		if(insertAchievement("SBQ-0775", "Fantôme Soryo Firefoux", "QUE-0629") != 0) return 1;
		if(insertAchievement("SBQ-0776", "Fantôme Tanukouï San", "QUE-0629") != 0) return 1;
		if(insertAchievement("SBQ-0777", "Fantôme Yokai Firefoux", "QUE-0629") != 0) return 1;

		if(insertAchievement("SUB-032", "Otomaï", "SUC-04") != 0) return 1;

		if(insertAchievement("CHA-095", "Tout le monde est là ?", "SUB-032") != 0) return 1;

		if(insertAchievement("QUE-0630", "Plage de Corail", "CHA-095") != 0) return 1;

		if(insertAchievement("SBQ-0778", "Corailleur", "QUE-0630") != 0) return 1;
		if(insertAchievement("SBQ-0779", "Crustorail Kouraçao", "QUE-0630") != 0) return 1;
		if(insertAchievement("SBQ-0780", "Crustorail Malibout", "QUE-0630") != 0) return 1;
		if(insertAchievement("SBQ-0781", "Crustorail Morito", "QUE-0630") != 0) return 1;
		if(insertAchievement("SBQ-0782", "Crustorail Passaoh", "QUE-0630") != 0) return 1;
		if(insertAchievement("SBQ-0783", "Palmifleur Kouraçao", "QUE-0630") != 0) return 1;
		if(insertAchievement("SBQ-0784", "Palmifleur Malibout", "QUE-0630") != 0) return 1;
		if(insertAchievement("SBQ-0785", "Palmifleur Morito", "QUE-0630") != 0) return 1;
		if(insertAchievement("SBQ-0786", "Palmifleur Passaoh", "QUE-0630") != 0) return 1;

		if(insertAchievement("QUE-0631", "Arche d''Otomaï", "CHA-095") != 0) return 1;

		if(insertAchievement("SBQ-0787", "Barbroussa", "QUE-0631") != 0) return 1;
		if(insertAchievement("SBQ-0788", "Le Flib", "QUE-0631") != 0) return 1;
		if(insertAchievement("SBQ-0789", "Sparo", "QUE-0631") != 0) return 1;

		if(insertAchievement("QUE-0632", "Plaines herbeuses", "CHA-095") != 0) return 1;

		if(insertAchievement("SBQ-0790", "Bitouf des Plaines", "QUE-0632") != 0) return 1;
		if(insertAchievement("SBQ-0791", "Craqueboule Poli", "QUE-0632") != 0) return 1;
		if(insertAchievement("SBQ-0792", "Craqueleur Poli", "QUE-0632") != 0) return 1;
		if(insertAchievement("SBQ-0793", "Kido", "QUE-0632") != 0) return 1;
		if(insertAchievement("SBQ-0794", "Kilibriss", "QUE-0632") != 0) return 1;
		if(insertAchievement("SBQ-0795", "Mufafah", "QUE-0632") != 0) return 1;

		if(insertAchievement("QUE-0633", "Village des Zoths", "CHA-095") != 0) return 1;

		if(insertAchievement("SBQ-0796", "Disciple Zoth", "QUE-0633") != 0) return 1;
		if(insertAchievement("SBQ-0797", "Gamine Zoth", "QUE-0633") != 0) return 1;
		if(insertAchievement("SBQ-0798", "Guerrier Zoth", "QUE-0633") != 0) return 1;
		if(insertAchievement("SBQ-0799", "Sergent Zoth", "QUE-0633") != 0) return 1;
		if(insertAchievement("SBQ-0800", "Maître Zoth", "QUE-0633") != 0) return 1;

		if(insertAchievement("QUE-0634", "Jungle Obscure", "CHA-095") != 0) return 1;

		if(insertAchievement("SBQ-0801", "Abrakleur Sombre", "QUE-0634") != 0) return 1;
		if(insertAchievement("SBQ-0802", "Bitouf Sombre", "QUE-0634") != 0) return 1;
		if(insertAchievement("SBQ-0803", "Brouture", "QUE-0634") != 0) return 1;
		if(insertAchievement("SBQ-0804", "Chiendent", "QUE-0634") != 0) return 1;
		if(insertAchievement("SBQ-0805", "Floribonde", "QUE-0634") != 0) return 1;
		if(insertAchievement("SBQ-0806", "Fécorce", "QUE-0634") != 0) return 1;
		if(insertAchievement("SBQ-0807", "Nerbe", "QUE-0634") != 0) return 1;

		if(insertAchievement("QUE-0635", "Tourbières", "CHA-095") != 0) return 1;

		if(insertAchievement("SBQ-0808", "Bourbassingue", "QUE-0635") != 0) return 1;
		if(insertAchievement("SBQ-0809", "La Ouassingue Entourbé", "QUE-0635") != 0) return 1;
		if(insertAchievement("SBQ-0810", "Roissingue", "QUE-0635") != 0) return 1;
		if(insertAchievement("SBQ-0811", "Tourbassingue", "QUE-0635") != 0) return 1;

		if(insertAchievement("QUE-0636", "Arbre Hakam", "CHA-095") != 0) return 1;

		if(insertAchievement("SBQ-0812", "Abrakleur Clair", "QUE-0636") != 0) return 1;
		if(insertAchievement("SBQ-0813", "Bitouf Aérien", "QUE-0636") != 0) return 1;
		if(insertAchievement("SBQ-0814", "Kaskargo", "QUE-0636") != 0) return 1;
		if(insertAchievement("SBQ-0815", "Meupette", "QUE-0636") != 0) return 1;
		if(insertAchievement("SBQ-0816", "Poolay", "QUE-0636") != 0) return 1;

		if(insertAchievement("SUB-033", "Frigost", "SUC-04") != 0) return 1;

		if(insertAchievement("CHA-096", "Sans froid ni loi", "SUB-033") != 0) return 1;

		if(insertAchievement("QUE-0637", "Bourgade", "CHA-096") != 0) return 1;

		if(insertAchievement("SBQ-0817", "Chachachovage", "QUE-0637") != 0) return 1;
		if(insertAchievement("SBQ-0818", "Crabe Hijacob", "QUE-0637") != 0) return 1;
		if(insertAchievement("SBQ-0819", "Gélikan", "QUE-0637") != 0) return 1;
		if(insertAchievement("SBQ-0820", "Rat Bougri", "QUE-0637") != 0) return 1;

		if(insertAchievement("QUE-0638", "Boufmouths", "CHA-096") != 0) return 1;

		if(insertAchievement("SBQ-0821", "Boufmouth", "QUE-0638") != 0) return 1;
		if(insertAchievement("SBQ-0822", "Boufmouth de guerre", "QUE-0638") != 0) return 1;
		if(insertAchievement("SBQ-0823", "Boufmouth légendaire", "QUE-0638") != 0) return 1;
		if(insertAchievement("SBQ-0824", "Bouftonmouth", "QUE-0638") != 0) return 1;

		if(insertAchievement("QUE-0639", "Mansots", "CHA-096") != 0) return 1;

		if(insertAchievement("SBQ-0825", "Fu Mansot", "QUE-0639") != 0) return 1;
		if(insertAchievement("SBQ-0826", "Mamansot", "QUE-0639") != 0) return 1;
		if(insertAchievement("SBQ-0827", "Mansobèse", "QUE-0639") != 0) return 1;
		if(insertAchievement("SBQ-0828", "Shamansot", "QUE-0639") != 0) return 1;
		if(insertAchievement("SBQ-0829", "Timansot", "QUE-0639") != 0) return 1;

		if(insertAchievement("QUE-0640", "Pins Perdus", "CHA-096") != 0) return 1;

		if(insertAchievement("SBQ-0830", "Ecumouth", "QUE-0640") != 0) return 1;
		if(insertAchievement("SBQ-0831", "Fricochère", "QUE-0640") != 0) return 1;
		if(insertAchievement("SBQ-0832", "Kaniglou", "QUE-0640") != 0) return 1;
		if(insertAchievement("SBQ-0833", "Sanglacier", "QUE-0640") != 0) return 1;
		if(insertAchievement("SBQ-0834", "Smilomouth", "QUE-0640") != 0) return 1;

		if(insertAchievement("QUE-0641", "Berceau d''Alma", "CHA-096") != 0) return 1;

		if(insertAchievement("SBQ-0835", "Fancrôme", "QUE-0641") != 0) return 1;
		if(insertAchievement("SBQ-0836", "Fantimonier", "QUE-0641") != 0) return 1;
		if(insertAchievement("SBQ-0837", "Fantomalamère", "QUE-0641") != 0) return 1;
		if(insertAchievement("SBQ-0838", "Fantomât", "QUE-0641") != 0) return 1;
		if(insertAchievement("SBQ-0839", "Harpirate", "QUE-0641") != 0) return 1;
		if(insertAchievement("SBQ-0840", "Vigie pirate", "QUE-0641") != 0) return 1;

		if(insertAchievement("QUE-0642", "Larmes d''Ouronigride", "CHA-096") != 0) return 1;

		if(insertAchievement("SBQ-0841", "Atomystique", "QUE-0642") != 0) return 1;
		if(insertAchievement("SBQ-0842", "Crapeur", "QUE-0642") != 0) return 1;
		if(insertAchievement("SBQ-0843", "Fumrirolle", "QUE-0642") != 0) return 1;
		if(insertAchievement("SBQ-0844", "Mofette", "QUE-0642") != 0) return 1;
		if(insertAchievement("SBQ-0845", "Solfataré", "QUE-0642") != 0) return 1;

		if(insertAchievement("QUE-0643", "Givrefoux", "CHA-096") != 0) return 1;

		if(insertAchievement("SBQ-0846", "Kami Givrefoux", "QUE-0643") != 0) return 1;
		if(insertAchievement("SBQ-0847", "Maho Givrefoux", "QUE-0643") != 0) return 1;
		if(insertAchievement("SBQ-0848", "Soryo Givrefoux", "QUE-0643") != 0) return 1;
		if(insertAchievement("SBQ-0849", "Yokaï Givrefoux", "QUE-0643") != 0) return 1;
		if(insertAchievement("SBQ-0850", "Yomi Givrefoux", "QUE-0643") != 0) return 1;

		if(insertAchievement("QUE-0644", "Forêt pétrifiée", "CHA-096") != 0) return 1;

		if(insertAchievement("SBQ-0851", "Abrazif", "QUE-0644") != 0) return 1;
		if(insertAchievement("SBQ-0852", "Dramanite", "QUE-0644") != 0) return 1;
		if(insertAchievement("SBQ-0853", "Fistulor", "QUE-0644") != 0) return 1;
		if(insertAchievement("SBQ-0854", "Fongeur", "QUE-0644") != 0) return 1;
		if(insertAchievement("SBQ-0855", "Mérulette", "QUE-0644") != 0) return 1;

		if(insertAchievement("QUE-0645", "Sakaï", "CHA-096") != 0) return 1;

		if(insertAchievement("SBQ-0856", "Courtillieur", "QUE-0645") != 0) return 1;
		if(insertAchievement("SBQ-0857", "Gobosteur", "QUE-0645") != 0) return 1;
		if(insertAchievement("SBQ-0858", "Gobus", "QUE-0645") != 0) return 1;
		if(insertAchievement("SBQ-0859", "Marôdeur", "QUE-0645") != 0) return 1;
		if(insertAchievement("SBQ-0860", "Ouilleur", "QUE-0645") != 0) return 1;
		if(insertAchievement("SBQ-0861", "Perkü", "QUE-0645") != 0) return 1;
		if(insertAchievement("SBQ-0862", "Sapeur", "QUE-0645") != 0) return 1;

		if(insertAchievement("QUE-0646", "Crocs de verre", "CHA-096") != 0) return 1;

		if(insertAchievement("SBQ-0863", "Blérauve", "QUE-0646") != 0) return 1;
		if(insertAchievement("SBQ-0864", "Blérice", "QUE-0646") != 0) return 1;
		if(insertAchievement("SBQ-0865", "Blérom", "QUE-0646") != 0) return 1;
		if(insertAchievement("SBQ-0866", "Croleur", "QUE-0646") != 0) return 1;
		if(insertAchievement("SBQ-0867", "Fleuro", "QUE-0646") != 0) return 1;
		if(insertAchievement("SBQ-0868", "Wolvero", "QUE-0646") != 0) return 1;

		if(insertAchievement("QUE-0647", "Gloursons", "CHA-096") != 0) return 1;

		if(insertAchievement("SBQ-0869", "Apériglours", "QUE-0647") != 0) return 1;
		if(insertAchievement("SBQ-0870", "Boulglours", "QUE-0647") != 0) return 1;
		if(insertAchievement("SBQ-0871", "Glouragan", "QUE-0647") != 0) return 1;
		if(insertAchievement("SBQ-0872", "Glourmand", "QUE-0647") != 0) return 1;
		if(insertAchievement("SBQ-0873", "Gloursaya", "QUE-0647") != 0) return 1;
		if(insertAchievement("SBQ-0874", "Meliglours", "QUE-0647") != 0) return 1;

		if(insertAchievement("CHA-097", "Froid de Koinkoin", "SUB-033") != 0) return 1;

		if(insertAchievement("QUE-0648", "Alchillusions", "CHA-097") != 0) return 1;

		if(insertAchievement("SBQ-0875", "Dodox", "QUE-0648") != 0) return 1;
		if(insertAchievement("SBQ-0876", "Drosérale", "QUE-0648") != 0) return 1;
		if(insertAchievement("SBQ-0877", "Krakal", "QUE-0648") != 0) return 1;
		if(insertAchievement("SBQ-0878", "Nessil", "QUE-0648") != 0) return 1;
		if(insertAchievement("SBQ-0879", "Termystique", "QUE-0648") != 0) return 1;

		if(insertAchievement("QUE-0649", "Armutins", "CHA-097") != 0) return 1;

		if(insertAchievement("SBQ-0880", "Frimar", "QUE-0649") != 0) return 1;
		if(insertAchievement("SBQ-0881", "Karkanik", "QUE-0649") != 0) return 1;
		if(insertAchievement("SBQ-0882", "Stalak", "QUE-0649") != 0) return 1;
		if(insertAchievement("SBQ-0883", "Ventrublion", "QUE-0649") != 0) return 1;
		if(insertAchievement("SBQ-0884", "Verglasseur", "QUE-0649") != 0) return 1;

		if(insertAchievement("QUE-0650", "Bricoléreux", "CHA-097") != 0) return 1;

		if(insertAchievement("SBQ-0885", "Bricoglours", "QUE-0650") != 0) return 1;
		if(insertAchievement("SBQ-0886", "Kanimate", "QUE-0650") != 0) return 1;
		if(insertAchievement("SBQ-0887", "Mansordide", "QUE-0650") != 0) return 1;
		if(insertAchievement("SBQ-0888", "Mécanofoux", "QUE-0650") != 0) return 1;
		if(insertAchievement("SBQ-0889", "Mérulor", "QUE-0650") != 0) return 1;

		if(insertAchievement("QUE-0651", "Cuirassés", "CHA-097") != 0) return 1;

		if(insertAchievement("SBQ-0890", "Cuirboule", "QUE-0651") != 0) return 1;
		if(insertAchievement("SBQ-0891", "Empaillé", "QUE-0651") != 0) return 1;
		if(insertAchievement("SBQ-0892", "Godruche", "QUE-0651") != 0) return 1;
		if(insertAchievement("SBQ-0893", "Harrogant", "QUE-0651") != 0) return 1;
		if(insertAchievement("SBQ-0894", "Peunch", "QUE-0651") != 0) return 1;

		if(insertAchievement("QUE-0652", "Sinistros", "CHA-097") != 0) return 1;

		if(insertAchievement("SBQ-0895", "Cycloïde", "QUE-0652") != 0) return 1;
		if(insertAchievement("SBQ-0896", "Granduk", "QUE-0652") != 0) return 1;
		if(insertAchievement("SBQ-0897", "Noctulabe", "QUE-0652") != 0) return 1;
		if(insertAchievement("SBQ-0898", "Sinistrofu", "QUE-0652") != 0) return 1;
		if(insertAchievement("SBQ-0899", "Strigide", "QUE-0652") != 0) return 1;

		if(insertAchievement("CHA-098", "Autres", "SUB-033") != 0) return 1;

		if(insertAchievement("QUE-0653", "Krobes", "CHA-098") != 0) return 1;

		if(insertAchievement("SBQ-0900", "Tabacille", "QUE-0653") != 0) return 1;
		if(insertAchievement("SBQ-0901", "Verminocule", "QUE-0653") != 0) return 1;
		if(insertAchievement("SBQ-0902", "Bacterrib", "QUE-0653") != 0) return 1;
		if(insertAchievement("SBQ-0903", "Virustine", "QUE-0653") != 0) return 1;
		if(insertAchievement("SBQ-0904", "Pataugerme", "QUE-0653") != 0) return 1;

		if(insertAchievement("SUB-034", "Dimensions", "SUC-04") != 0) return 1;

		if(insertAchievement("CHA-099", "Ruée vers l''or", "SUB-034") != 0) return 1;

		if(insertAchievement("QUE-0654", "Koffrefors", "CHA-099") != 0) return 1;

		if(insertAchievement("SBQ-0905", "Bersekoffre", "QUE-0654") != 0) return 1;
		if(insertAchievement("SBQ-0906", "Boursoin", "QUE-0654") != 0) return 1;
		if(insertAchievement("SBQ-0907", "Mimikado", "QUE-0654") != 0) return 1;
		if(insertAchievement("SBQ-0908", "Précieux", "QUE-0654") != 0) return 1;
		if(insertAchievement("SBQ-0909", "Trésantène", "QUE-0654") != 0) return 1;

		if(insertAchievement("QUE-0655", "Phorreurs", "CHA-099") != 0) return 1;

		if(insertAchievement("SBQ-0910", "Mère Veilleuse", "QUE-0655") != 0) return 1;
		if(insertAchievement("SBQ-0911", "Métaphorreur", "QUE-0655") != 0) return 1;
		if(insertAchievement("SBQ-0912", "Phorrêveur", "QUE-0655") != 0) return 1;
		if(insertAchievement("SBQ-0913", "Phozami", "QUE-0655") != 0) return 1;
		if(insertAchievement("SBQ-0914", "Père Phorreur", "QUE-0655") != 0) return 1;

		if(insertAchievement("QUE-0656", "Enutrofors", "CHA-099") != 0) return 1;

		if(insertAchievement("SBQ-0915", "Barbétoal", "QUE-0656") != 0) return 1;
		if(insertAchievement("SBQ-0916", "Kamastérisk", "QUE-0656") != 0) return 1;
		if(insertAchievement("SBQ-0917", "Lévitrof", "QUE-0656") != 0) return 1;
		if(insertAchievement("SBQ-0918", "Paspartou", "QUE-0656") != 0) return 1;
		if(insertAchievement("SBQ-0919", "Piloztère", "QUE-0656") != 0) return 1;

		if(insertAchievement("CHA-100", "Malfracturés", "SUB-034") != 0) return 1;

		if(insertAchievement("QUE-0657", "Malveilleurs", "CHA-100") != 0) return 1;

		if(insertAchievement("SBQ-0920", "Milimaître", "QUE-0657") != 0) return 1;
		if(insertAchievement("SBQ-0921", "Kartouche", "QUE-0657") != 0) return 1;
		if(insertAchievement("SBQ-0922", "Sramouraï", "QUE-0657") != 0) return 1;
		if(insertAchievement("SBQ-0923", "Tromblion", "QUE-0657") != 0) return 1;
		if(insertAchievement("SBQ-0924", "Elsoummo", "QUE-0657") != 0) return 1;

		if(insertAchievement("QUE-0658", "Nécrotiques", "CHA-100") != 0) return 1;

		if(insertAchievement("SBQ-0925", "Scoliopode", "QUE-0658") != 0) return 1;
		if(insertAchievement("SBQ-0926", "Puceronde", "QUE-0658") != 0) return 1;
		if(insertAchievement("SBQ-0927", "Lucrane", "QUE-0658") != 0) return 1;
		if(insertAchievement("SBQ-0928", "Eperfide", "QUE-0658") != 0) return 1;
		if(insertAchievement("SBQ-0929", "Morfrelon", "QUE-0658") != 0) return 1;

		if(insertAchievement("QUE-0659", "Cour Sombre", "CHA-100") != 0) return 1;

		if(insertAchievement("SBQ-0930", "Mâchassin", "QUE-0659") != 0) return 1;
		if(insertAchievement("SBQ-0931", "Terristocrate", "QUE-0659") != 0) return 1;
		if(insertAchievement("SBQ-0932", "Doublure", "QUE-0659") != 0) return 1;
		if(insertAchievement("SBQ-0933", "Bourôliste", "QUE-0659") != 0) return 1;
		if(insertAchievement("SBQ-0934", "Magouille", "QUE-0659") != 0) return 1;

		if(insertAchievement("CHA-101", "Passer le temps", "SUB-034") != 0) return 1;

		if(insertAchievement("QUE-0660", "Xélomorphes", "CHA-101") != 0) return 1;

		if(insertAchievement("SBQ-0935", "Gromorso", "QUE-0660") != 0) return 1;
		if(insertAchievement("SBQ-0936", "Farfacette", "QUE-0660") != 0) return 1;
		if(insertAchievement("SBQ-0937", "Brikablak", "QUE-0660") != 0) return 1;
		if(insertAchievement("SBQ-0938", "Éklatleth", "QUE-0660") != 0) return 1;
		if(insertAchievement("SBQ-0939", "Segmantid", "QUE-0660") != 0) return 1;

		if(insertAchievement("QUE-0661", "Hordémons", "CHA-101") != 0) return 1;

		if(insertAchievement("SBQ-0940", "Trezz", "QUE-0661") != 0) return 1;
		if(insertAchievement("SBQ-0941", "Vindeux", "QUE-0661") != 0) return 1;
		if(insertAchievement("SBQ-0942", "Trantroa", "QUE-0661") != 0) return 1;
		if(insertAchievement("SBQ-0943", "Seith", "QUE-0661") != 0) return 1;
		if(insertAchievement("SBQ-0944", "Soissanth", "QUE-0661") != 0) return 1;

		if(insertAchievement("QUE-0662", "Égarés", "CHA-101") != 0) return 1;

		if(insertAchievement("SBQ-0945", "Ikargn", "QUE-0662") != 0) return 1;
		if(insertAchievement("SBQ-0946", "Méjaire", "QUE-0662") != 0) return 1;
		if(insertAchievement("SBQ-0947", "Harpille", "QUE-0662") != 0) return 1;
		if(insertAchievement("SBQ-0948", "Buboxor", "QUE-0662") != 0) return 1;
		if(insertAchievement("SBQ-0949", "Brabuzar", "QUE-0662") != 0) return 1;

		if(insertAchievement("CHA-102", "De simples pions", "SUB-034") != 0) return 1;

		if(insertAchievement("QUE-0663", "Ecaflipuces", "CHA-102") != 0) return 1;

		if(insertAchievement("SBQ-0950", "Pupuce", "QUE-0663") != 0) return 1;
		if(insertAchievement("SBQ-0951", "Morcac", "QUE-0663") != 0) return 1;
		if(insertAchievement("SBQ-0952", "Pikbul", "QUE-0663") != 0) return 1;
		if(insertAchievement("SBQ-0953", "Gériatique", "QUE-0663") != 0) return 1;
		if(insertAchievement("SBQ-0954", "Grath", "QUE-0663") != 0) return 1;

		if(insertAchievement("QUE-0664", "Matougarous", "CHA-102") != 0) return 1;

		if(insertAchievement("SBQ-0955", "Chasquatch", "QUE-0664") != 0) return 1;
		if(insertAchievement("SBQ-0956", "Chacrebleu", "QUE-0664") != 0) return 1;
		if(insertAchievement("SBQ-0957", "Chakichan", "QUE-0664") != 0) return 1;
		if(insertAchievement("SBQ-0958", "Chargus", "QUE-0664") != 0) return 1;
		if(insertAchievement("SBQ-0959", "Chakaroze", "QUE-0664") != 0) return 1;

		if(insertAchievement("QUE-0665", "Grand Jeu", "CHA-102") != 0) return 1;

		if(insertAchievement("SBQ-0960", "Soldat de Fortune", "QUE-0665") != 0) return 1;
		if(insertAchievement("SBQ-0961", "Valet Veinard", "QUE-0665") != 0) return 1;
		if(insertAchievement("SBQ-0962", "Cavalier Chanceux", "QUE-0665") != 0) return 1;
		if(insertAchievement("SBQ-0963", "Dame du Hasard", "QUE-0665") != 0) return 1;
		if(insertAchievement("SBQ-0964", "Roi Joueur", "QUE-0665") != 0) return 1;

		if(insertAchievement("CHA-103", "Autres", "SUB-034") != 0) return 1;

		if(insertAchievement("QUE-0666", "Obscuranti", "CHA-103") != 0) return 1;

		if(insertAchievement("SBQ-0965", "Panterreur", "QUE-0666") != 0) return 1;
		if(insertAchievement("SBQ-0966", "Brutopak", "QUE-0666") != 0) return 1;
		if(insertAchievement("SBQ-0967", "Noctulule", "QUE-0666") != 0) return 1;
		if(insertAchievement("SBQ-0968", "Caznoar", "QUE-0666") != 0) return 1;
		if(insertAchievement("SBQ-0969", "Sombléro", "QUE-0666") != 0) return 1;

		if(insertAchievement("SUB-035", "Saharach", "SUC-04") != 0) return 1;

		if(insertAchievement("CHA-104", "Tempête de sable", "SUB-035") != 0) return 1;

		if(insertAchievement("QUE-0667", "Animaux du désert", "CHA-104") != 0) return 1;

		if(insertAchievement("SBQ-0970", "Fennex", "QUE-0667") != 0) return 1;
		if(insertAchievement("SBQ-0971", "Léolhyène", "QUE-0667") != 0) return 1;
		if(insertAchievement("SBQ-0972", "Ouroboulos", "QUE-0667") != 0) return 1;
		if(insertAchievement("SBQ-0973", "Boulépique", "QUE-0667") != 0) return 1;
		if(insertAchievement("SBQ-0974", "Scordion Bleu", "QUE-0667") != 0) return 1;

		if(insertAchievement("QUE-0668", "Cacterres", "CHA-104") != 0) return 1;

		if(insertAchievement("SBQ-0975", "Cactana", "QUE-0668") != 0) return 1;
		if(insertAchievement("SBQ-0976", "Cactiflore", "QUE-0668") != 0) return 1;
		if(insertAchievement("SBQ-0977", "Cactoblongo", "QUE-0668") != 0) return 1;
		if(insertAchievement("SBQ-0978", "Lévito", "QUE-0668") != 0) return 1;
		if(insertAchievement("SBQ-0979", "Pampactus", "QUE-0668") != 0) return 1;

		if(insertAchievement("QUE-0669", "Vers des sables", "CHA-104") != 0) return 1;

		if(insertAchievement("SBQ-0980", "Trémorse", "QUE-0669") != 0) return 1;
		if(insertAchievement("SBQ-0981", "Masticroc", "QUE-0669") != 0) return 1;
		if(insertAchievement("SBQ-0982", "Morsquale", "QUE-0669") != 0) return 1;
		if(insertAchievement("SBQ-0983", "Cycloporth", "QUE-0669") != 0) return 1;
		if(insertAchievement("SBQ-0984", "Pikténia", "QUE-0669") != 0) return 1;

		if(insertAchievement("QUE-0670", "Maudits", "CHA-104") != 0) return 1;

		if(insertAchievement("SBQ-0985", "Chakanoubis", "QUE-0670") != 0) return 1;
		if(insertAchievement("SBQ-0986", "Bandleth", "QUE-0670") != 0) return 1;
		if(insertAchievement("SBQ-0987", "Momistik", "QUE-0670") != 0) return 1;
		if(insertAchievement("SBQ-0988", "Rykaon", "QUE-0670") != 0) return 1;
		if(insertAchievement("SBQ-0989", "Griffotep", "QUE-0670") != 0) return 1;
		

		


		
		
		
		
		
		
		
		
		
		// QUETES
		
		if(insertAchievement("SUB-036", "Général", "SUC-05") != 0) return 1;



		if(insertAchievement("CHA-105", "Arrivée dans la cour des grands", "SUB-036") != 0) return 1;


		if(insertAchievement("QUE-0671", "En route pour l''aventure", "CHA-105") != 0) return 1;

		if(insertAchievement("QUE-0672", "Des débuts exemplaires", "CHA-105") != 0) return 1;

		if(insertAchievement("QUE-0673", "Un disciple modèle", "CHA-105") != 0) return 1;

		if(insertAchievement("QUE-0674", "Astrub a un incroyable talent", "CHA-105") != 0) return 1;


		if(insertAchievement("CHA-106", "Les petits pédestres", "SUB-036") != 0) return 1;


		if(insertAchievement("QUE-0675", "Le théâtre des gobelins", "CHA-106") != 0) return 1;

		if(insertAchievement("QUE-0676", "Kaïra", "CHA-106") != 0) return 1;

		if(insertAchievement("QUE-0677", "Le vallon du château", "CHA-106") != 0) return 1;

		if(insertAchievement("QUE-0678", "Convoyeur de fond en comble", "CHA-106") != 0) return 1;

		if(insertAchievement("QUE-0679", "Léchage de bottes", "CHA-106") != 0) return 1;

		if(insertAchievement("QUE-0680", "Destination Aventure", "CHA-106") != 0) return 1;

		if(insertAchievement("QUE-0681", "La bonne attitude", "CHA-106") != 0) return 1;

		if(insertAchievement("QUE-0682", "Être plus royaliste que le roi", "CHA-106") != 0) return 1;


		if(insertAchievement("CHA-107", "Le trésor d''Otomaï", "SUB-036") != 0) return 1;


		if(insertAchievement("QUE-0683", "Y''a qu''Otomaï qui m''aille", "CHA-107") != 0) return 1;

		if(insertAchievement("QUE-0684", "La fin de l''éternité", "CHA-107") != 0) return 1;


		if(insertAchievement("CHA-108", "Les mystères de Frigost", "SUB-036") != 0) return 1;


		if(insertAchievement("QUE-0685", "Oeuf à la neige", "CHA-108") != 0) return 1;

		if(insertAchievement("QUE-0686", "L''ère glaciaire", "CHA-108") != 0) return 1;

		if(insertAchievement("QUE-0687", "Commission impossible", "CHA-108") != 0) return 1;

		if(insertAchievement("QUE-0688", "C''est l''heure de faire le comte", "CHA-108") != 0) return 1;

		if(insertAchievement("QUE-0689", "Épilogue hivernal", "CHA-108") != 0) return 1;


		if(insertAchievement("CHA-109", "En quête de preuves (10 quêtes)", "SUB-036") != 0) return 1;

		if(insertAchievement("CHA-110", "En quête de vérité (50 quêtes)", "SUB-036") != 0) return 1;

		if(insertAchievement("CHA-111", "En quête de solutions (100 quêtes)", "SUB-036") != 0) return 1;

		if(insertAchievement("CHA-112", "En quête de sens (200 quêtes)", "SUB-036") != 0) return 1;

		if(insertAchievement("CHA-113", "En quête d''identité (300 quêtes)", "SUB-036") != 0) return 1;

		if(insertAchievement("CHA-114", "En quête de soi (400 quêtes)", "SUB-036") != 0) return 1;

		if(insertAchievement("CHA-115", "En quête de reconnaissance (500 quêtes)", "SUB-036") != 0) return 1;

		if(insertAchievement("CHA-116", "En quête de respect (600 quêtes)", "SUB-036") != 0) return 1;

		if(insertAchievement("CHA-117", "En quête de gloire (700 quêtes)", "SUB-036") != 0) return 1;

		if(insertAchievement("CHA-118", "En quête de victoire (800 quêtes)", "SUB-036") != 0) return 1;

		if(insertAchievement("CHA-119", "En quête d''exploits (900 quêtes)", "SUB-036") != 0) return 1;

		if(insertAchievement("CHA-120", "En quête de héros (1000 quêtes)", "SUB-036") != 0) return 1;

		if(insertAchievement("CHA-121", "En quête de renom (1100 quêtes)", "SUB-036") != 0) return 1;

		if(insertAchievement("CHA-122", "En quête de perfection (1200 quêtes)", "SUB-036") != 0) return 1;

		if(insertAchievement("CHA-123", "En quête du destin (1300 quêtes)", "SUB-036") != 0) return 1;



		if(insertAchievement("SUB-037", "Quêtes Principales", "SUC-05") != 0) return 1;



		if(insertAchievement("CHA-124", "Quatre sur six", "SUB-037") != 0) return 1;


		if(insertAchievement("QUE-0690", "Quêtes des Dofus Élémentaires", "CHA-124") != 0) return 1;

		if(insertAchievement("SBQ-0990", "La dernière pierre", "QUE-0690") != 0) return 1;
		if(insertAchievement("SBQ-0991", "Les coûts du sort", "QUE-0690") != 0) return 1;
		if(insertAchievement("SBQ-0992", "Une ombre au tableau", "QUE-0690") != 0) return 1;
		if(insertAchievement("SBQ-0993", "Un remède draconien", "QUE-0690") != 0) return 1;
		if(insertAchievement("SBQ-0994", "Le dragon des eaux", "QUE-0690") != 0) return 1;
		if(insertAchievement("SBQ-0995", "Le dragon des vents", "QUE-0690") != 0) return 1;
		if(insertAchievement("SBQ-0996", "Le dragon des flammes", "QUE-0690") != 0) return 1;
		if(insertAchievement("SBQ-0997", "Le dragon des forêts", "QUE-0690") != 0) return 1;
		if(insertAchievement("SBQ-0998", "Mississitudes", "QUE-0690") != 0) return 1;
		if(insertAchievement("SBQ-0999", "Le destin de Kalisthe", "QUE-0690") != 0) return 1;



		if(insertAchievement("CHA-125", "Oeuf à la neige", "SUB-037") != 0) return 1;


		if(insertAchievement("QUE-0691", "Fri carré", "CHA-125") != 0) return 1;

		if(insertAchievement("SBQ-1000", "La terre banquise.", "QUE-0691") != 0) return 1;
		if(insertAchievement("SBQ-1001", "La maire de glace.", "QUE-0691") != 0) return 1;
		if(insertAchievement("SBQ-1002", "Full contact.", "QUE-0691") != 0) return 1;

		if(insertAchievement("QUE-0692", "Halte au péage", "CHA-125") != 0) return 1;

		if(insertAchievement("SBQ-1003", "Antiroyaliste.", "QUE-0692") != 0) return 1;
		if(insertAchievement("SBQ-1004", "Les joyeux de la couronne.", "QUE-0692") != 0) return 1;
		if(insertAchievement("SBQ-1005", "Fais dodo, t''auras du gâteau.", "QUE-0692") != 0) return 1;
		if(insertAchievement("SBQ-1006", "Lavomatique.", "QUE-0692") != 0) return 1;
		if(insertAchievement("SBQ-1007", "C''est frais, mais c''est pas grave.", "QUE-0692") != 0) return 1;
		if(insertAchievement("SBQ-1008", "Sans ma barbe, quelle barbe.", "QUE-0692") != 0) return 1;
		if(insertAchievement("SBQ-1009", "Là-haut sur la montagne.", "QUE-0692") != 0) return 1;
		if(insertAchievement("SBQ-1010", "Le pic qui glace.", "QUE-0692") != 0) return 1;

		if(insertAchievement("QUE-0693", "La maire dénie", "CHA-125") != 0) return 1;

		if(insertAchievement("SBQ-1011", "Bienvenue à Frigost.", "QUE-0693") != 0) return 1;
		if(insertAchievement("SBQ-1012", "L''essentiel est dans Lac Gelé.", "QUE-0693") != 0) return 1;
		if(insertAchievement("SBQ-1013", "Les rescapés de Frigost.", "QUE-0693") != 0) return 1;
		if(insertAchievement("SBQ-1014", "Frigost, une île pas comme les autres.", "QUE-0693") != 0) return 1;
		if(insertAchievement("SBQ-1015", "Développement durable.", "QUE-0693") != 0) return 1;
		if(insertAchievement("SBQ-1016", "Donjons et trouffions.", "QUE-0693") != 0) return 1;
		if(insertAchievement("SBQ-1017", "Au fion du trou.", "QUE-0693") != 0) return 1;

		if(insertAchievement("QUE-0694", "L''hiver arrive", "CHA-125") != 0) return 1;

		if(insertAchievement("SBQ-1018", "Les rescapés du Village Enseveli", "QUE-0694") != 0) return 1;
		if(insertAchievement("SBQ-1019", "Les derniers rescapés", "QUE-0694") != 0) return 1;
		if(insertAchievement("SBQ-1020", "La vie de château", "QUE-0694") != 0) return 1;
		if(insertAchievement("SBQ-1021", "La machine à démonter le temps", "QUE-0694") != 0) return 1;
		if(insertAchievement("SBQ-1022", "Il faut mettre un terme aux maîtres", "QUE-0694") != 0) return 1;
		if(insertAchievement("SBQ-1023", "Un comte de faits divers", "QUE-0694") != 0) return 1;

		if(insertAchievement("QUE-0695", "L''âme de glace", "CHA-125") != 0) return 1;

		if(insertAchievement("SBQ-1024", "Prologue", "QUE-0695") != 0) return 1;
		if(insertAchievement("SBQ-1025", "Malédiction!", "QUE-0695") != 0) return 1;
		if(insertAchievement("SBQ-1026", "Mission solution", "QUE-0695") != 0) return 1;
		if(insertAchievement("SBQ-1027", "Chaud et froid", "QUE-0695") != 0) return 1;
		if(insertAchievement("SBQ-1028", "Le givre des révélations", "QUE-0695") != 0) return 1;

		if(insertAchievement("QUE-0696", "Fraîchement pondu", "CHA-125") != 0) return 1;

		if(insertAchievement("SBQ-1029", "Le Dofus des Glaces", "QUE-0696") != 0) return 1;



		if(insertAchievement("CHA-126", "Odyssée en trois dimensions", "SUB-037") != 0) return 1;


		if(insertAchievement("QUE-0697", "D''un monde à l''autre", "CHA-126") != 0) return 1;

		if(insertAchievement("SBQ-1030", "Voyage, voyage", "QUE-0697") != 0) return 1;
		if(insertAchievement("SBQ-1031", "La porte d''Enutrofor", "QUE-0697") != 0) return 1;
		if(insertAchievement("SBQ-1032", "Orichomania", "QUE-0697") != 0) return 1;


		if(insertAchievement("QUE-0698", "Aux portes de la nuit", "CHA-126") != 0) return 1;

		if(insertAchievement("SBQ-1033", "La cité de l''indicible mal", "QUE-0698") != 0) return 1;
		if(insertAchievement("SBQ-1034", "Messager clandestin", "QUE-0698") != 0) return 1;
		if(insertAchievement("SBQ-1035", "La voix de son maître", "QUE-0698") != 0) return 1;


		if(insertAchievement("QUE-0699", "Générations futures", "CHA-126") != 0) return 1;

		if(insertAchievement("SBQ-1036", "Le maître des zaaps", "QUE-0699") != 0) return 1;
		if(insertAchievement("SBQ-1037", "Énergie renouvelable", "QUE-0699") != 0) return 1;
		if(insertAchievement("SBQ-1038", "Traitement de choc", "QUE-0699") != 0) return 1;


		if(insertAchievement("QUE-0700", "Par-delà les apparences", "CHA-126") != 0) return 1;

		if(insertAchievement("SBQ-1039", "Le disparu de Sufokia", "QUE-0700") != 0) return 1;
		if(insertAchievement("SBQ-1040", "Rendez-vous avec la mort", "QUE-0700") != 0) return 1;
		if(insertAchievement("SBQ-1041", "Secret de fabrication", "QUE-0700") != 0) return 1;
		if(insertAchievement("SBQ-1042", "S''emparer des commandes", "QUE-0700") != 0) return 1;
		if(insertAchievement("SBQ-1043", "C''est dans la boîte", "QUE-0700") != 0) return 1;
		if(insertAchievement("SBQ-1044", "Crise d''identité", "QUE-0700") != 0) return 1;

		if(insertAchievement("CHA-127", "Autres", "SUB-037") != 0) return 1;



		if(insertAchievement("QUE-0701", "En route pour l''aventure", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1045", "L''idole des jeunes", "QUE-0701") != 0) return 1;
		if(insertAchievement("SBQ-1046", "Sous le regard des dieux", "QUE-0701") != 0) return 1;
		if(insertAchievement("SBQ-1047", "Réponses à tout", "QUE-0701") != 0) return 1;
		if(insertAchievement("SBQ-1048", "Le village dans les nuages", "QUE-0701") != 0) return 1;
		if(insertAchievement("SBQ-1049", "Espoirs et tragédies", "QUE-0701") != 0) return 1;
		if(insertAchievement("SBQ-1050", "Dans la gueule du Milimilou", "QUE-0701") != 0) return 1;
		if(insertAchievement("SBQ-1051", "Départ pour Astrub", "QUE-0701") != 0) return 1;


		if(insertAchievement("QUE-0702", "Un disciple modèle", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1052", "Arrivée discrète.", "QUE-0702") != 0) return 1;
		if(insertAchievement("SBQ-1053", "L''avis d''Archie m''aide.", "QUE-0702") != 0) return 1;
		if(insertAchievement("SBQ-1054", "Quête de classe", "QUE-0702") != 0) return 1;
		if(insertAchievement("SBQ-1055", "Quête de dévotion", "QUE-0702") != 0) return 1;
		if(insertAchievement("SBQ-1056", "Rumeurs astrubiennes", "QUE-0702") != 0) return 1;
		if(insertAchievement("SBQ-1057", "L''arche de Nowa", "QUE-0702") != 0) return 1;
		if(insertAchievement("SBQ-1058", "À la recherche des Enus disparus", "QUE-0702") != 0) return 1;

		if(insertAchievement("QUE-0703", "Mais où sont les Dofus?", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1059", "Quête des coutumes de Pandala", "QUE-0703") != 0) return 1;
		if(insertAchievement("SBQ-1060", "Pandala: ses villages...", "QUE-0703") != 0) return 1;
		if(insertAchievement("SBQ-1061", "Pandala: son air pur...", "QUE-0703") != 0) return 1;
		if(insertAchievement("SBQ-1062", "Légende lenalde", "QUE-0703") != 0) return 1;
		if(insertAchievement("SBQ-1063", "Voir le Dark Vlad et ne pas mourir", "QUE-0703") != 0) return 1;
		if(insertAchievement("SBQ-1064", "La magicienne des marécages", "QUE-0703") != 0) return 1;


		if(insertAchievement("QUE-0704", "Vert émeraude", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1065", "Retourner voir le Dark Vlad, toujours sans mourir", "QUE-0704") != 0) return 1;
		if(insertAchievement("SBQ-1066", "Qui botte le cul des Culs Bottés?", "QUE-0704") != 0) return 1;
		if(insertAchievement("SBQ-1067", "Le voleur d''âmes", "QUE-0704") != 0) return 1;
		if(insertAchievement("SBQ-1068", "L''amour perdu de Nabur", "QUE-0704") != 0) return 1;
		if(insertAchievement("SBQ-1069", "Naissance d''une vocation", "QUE-0704") != 0) return 1;
		if(insertAchievement("SBQ-1070", "Les bandits de Cania", "QUE-0704") != 0) return 1;
		if(insertAchievement("SBQ-1071", "Draconanthropie", "QUE-0704") != 0) return 1;
		if(insertAchievement("SBQ-1072", "Ultime réminiscence", "QUE-0704") != 0) return 1;


		if(insertAchievement("QUE-0705", "Pourpre profond", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1073", "Le livre des Taures", "QUE-0705") != 0) return 1;
		if(insertAchievement("SBQ-1074", "Taures et détours", "QUE-0705") != 0) return 1;
		if(insertAchievement("SBQ-1075", "Le trésor de Totankama", "QUE-0705") != 0) return 1;
		if(insertAchievement("SBQ-1076", "Il faut battre le lait quand il est chaud", "QUE-0705") != 0) return 1;
		if(insertAchievement("SBQ-1077", "Regrets d''éternailes", "QUE-0705") != 0) return 1;
		if(insertAchievement("SBQ-1078", "L''anneau de Tot", "QUE-0705") != 0) return 1;
		if(insertAchievement("SBQ-1079", "Une âme en peine", "QUE-0705") != 0) return 1;
		if(insertAchievement("SBQ-1080", "Le pouvoir derrière le trône", "QUE-0705") != 0) return 1;


		if(insertAchievement("QUE-0706", "Bleu turquoise", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1081", "Plongeon et dragon", "QUE-0706") != 0) return 1;
		if(insertAchievement("SBQ-1082", "Extinction des feux", "QUE-0706") != 0) return 1;
		if(insertAchievement("SBQ-1083", "On dirait le Sud", "QUE-0706") != 0) return 1;
		if(insertAchievement("SBQ-1084", "La méchante sorcière de l''Est", "QUE-0706") != 0) return 1;
		if(insertAchievement("SBQ-1085", "Autel du Nord", "QUE-0706") != 0) return 1;
		if(insertAchievement("SBQ-1086", "Il était une foi dans l''Ouest", "QUE-0706") != 0) return 1;
		if(insertAchievement("SBQ-1087", "La bénédiction de Viti", "QUE-0706") != 0) return 1;
		if(insertAchievement("SBQ-1088", "La bénédiction de Thomahon", "QUE-0706") != 0) return 1;
		if(insertAchievement("SBQ-1089", "La bénédiction de Foluk", "QUE-0706") != 0) return 1;
		if(insertAchievement("SBQ-1090", "Une âme en colère", "QUE-0706") != 0) return 1;


		if(insertAchievement("QUE-0707", "La fin de l''éternité", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1091", "L''éternelle moisson.", "QUE-0707") != 0) return 1;


		if(insertAchievement("QUE-0708", "Épilogue hivernal", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1092", "Mille et un jours, un destin", "QUE-0708") != 0) return 1;


		if(insertAchievement("QUE-0709", "La bonne attitude", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1093", "Manuscrit de Terra Cogita", "QUE-0709") != 0) return 1;


		if(insertAchievement("QUE-0710", "Être plus royaliste que le roi", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1094", "Le Guide du Roublard", "QUE-0710") != 0) return 1;
		if(insertAchievement("SBQ-1095", "Crypte Honnie", "QUE-0710") != 0) return 1;
		if(insertAchievement("SBQ-1096", "Traître ou pas traître, telle est la question...", "QUE-0710") != 0) return 1;
		if(insertAchievement("SBQ-1097", "Quatrième quête d''Allister", "QUE-0710") != 0) return 1;
		if(insertAchievement("SBQ-1098", "Cinquième quête d''Allister", "QUE-0710") != 0) return 1;
		if(insertAchievement("SBQ-1099", "Sixième quête d''Allister", "QUE-0710") != 0) return 1;
		if(insertAchievement("SBQ-1100", "Septième quête d''Allister", "QUE-0710") != 0) return 1;
		if(insertAchievement("SBQ-1101", "Huitième quête d''Allister", "QUE-0710") != 0) return 1;
		if(insertAchievement("SBQ-1102", "Neuvième quête d''Allister", "QUE-0710") != 0) return 1;


		if(insertAchievement("QUE-0711", "Le tour du monde en 27 donjons", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1103", "Le tour du monde", "QUE-0711") != 0) return 1;
		if(insertAchievement("SBQ-1104", "Le maître des clefs", "QUE-0711") != 0) return 1;
		if(insertAchievement("SBQ-1105", "Les sbires du maître", "QUE-0711") != 0) return 1;
		if(insertAchievement("SBQ-1106", "Un juge hystérique", "QUE-0711") != 0) return 1;
		if(insertAchievement("SBQ-1107", "Des donjons, encore des donjons", "QUE-0711") != 0) return 1;
		if(insertAchievement("SBQ-1108", "La voie du guerrier", "QUE-0711") != 0) return 1;
		if(insertAchievement("SBQ-1109", "Le tracas du guerrier", "QUE-0711") != 0) return 1;


		if(insertAchievement("QUE-0712", "Première édition de donjons", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1110", "L''Étoile du gerbé", "QUE-0712") != 0) return 1;
		if(insertAchievement("SBQ-1111", "Donjon en mousse", "QUE-0712") != 0) return 1;
		if(insertAchievement("SBQ-1112", "Donjon en lambeaux", "QUE-0712") != 0) return 1;
		if(insertAchievement("SBQ-1113", "Donjon douillet", "QUE-0712") != 0) return 1;
		if(insertAchievement("SBQ-1114", "Donjon magistral", "QUE-0712") != 0) return 1;


		if(insertAchievement("QUE-0713", "Donjons avancés", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1115", "T''as le blop coco", "QUE-0713") != 0) return 1;
		if(insertAchievement("SBQ-1116", "Blop indigo, go, go", "QUE-0713") != 0) return 1;
		if(insertAchievement("SBQ-1117", "Le blop griotte entre les repas", "QUE-0713") != 0) return 1;
		if(insertAchievement("SBQ-1118", "Blop de reinette sans blop d''api", "QUE-0713") != 0) return 1;
		if(insertAchievement("SBQ-1119", "Un Kanniboul versé", "QUE-0713") != 0) return 1;
		if(insertAchievement("SBQ-1120", "Le Wa Pythie", "QUE-0713") != 0) return 1;


		if(insertAchievement("QUE-0714", "Donjons trois point cinq", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1121", "Gelée bien eue", "QUE-0714") != 0) return 1;
		if(insertAchievement("SBQ-1122", "Chéri fais-moi peur", "QUE-0714") != 0) return 1;
		if(insertAchievement("SBQ-1123", "Histoire de chiens", "QUE-0714") != 0) return 1;
		if(insertAchievement("SBQ-1124", "Le roman de Kitsoune", "QUE-0714") != 0) return 1;
		if(insertAchievement("SBQ-1125", "Un défilé de Wobots", "QUE-0714") != 0) return 1;


		if(insertAchievement("QUE-0715", "Le siège des donjons", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1126", "Tour de marionnettes", "QUE-0715") != 0) return 1;
		if(insertAchievement("SBQ-1127", "Tour d''horizon", "QUE-0715") != 0) return 1;
		if(insertAchievement("SBQ-1128", "Tour à tour", "QUE-0715") != 0) return 1;
		if(insertAchievement("SBQ-1129", "Tour de table", "QUE-0715") != 0) return 1;
		if(insertAchievement("SBQ-1130", "Tour de passe-passe", "QUE-0715") != 0) return 1;


		if(insertAchievement("QUE-0716", "La tornade des donjons", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1131", "Tour de rein", "QUE-0716") != 0) return 1;
		if(insertAchievement("SBQ-1132", "Tour de main", "QUE-0716") != 0) return 1;
		if(insertAchievement("SBQ-1133", "Tour de force", "QUE-0716") != 0) return 1;
		if(insertAchievement("SBQ-1134", "Tour nage", "QUE-0716") != 0) return 1;
		if(insertAchievement("SBQ-1135", "Le tour est joué", "QUE-0716") != 0) return 1;


		if(insertAchievement("QUE-0717", "Errances félines", "CHA-127") != 0) return 1;

		if(insertAchievement("SBQ-1136", "Chacun cherche son chacha", "QUE-0717") != 0) return 1;
		if(insertAchievement("SBQ-1137", "Question de réputation", "QUE-0717") != 0) return 1;
		if(insertAchievement("SBQ-1138", "Matou vu", "QUE-0717") != 0) return 1;



		if(insertAchievement("SUB-038", "Almanax", "SUC-05") != 0) return 1;


		if(insertAchievement("CHA-128", "Le repos du dragon", "SUB-038") != 0) return 1;

		if(insertAchievement("QUE-0718", "L''année du dragon", "CHA-128") != 0) return 1;

		if(insertAchievement("CHA-129", "Ce n''est qu''un début (1 page)", "QUE-0718") != 0) return 1;
		if(insertAchievement("CHA-130", "Quelle assiduité (100 pages)", "QUE-0718") != 0) return 1;
		if(insertAchievement("CHA-131", "Courage, ça avance (200 pages)", "QUE-0718") != 0) return 1;
		if(insertAchievement("CHA-132", "Dernière ligne droite (300 pages)", "QUE-0718") != 0) return 1;


		if(insertAchievement("SUB-039", "Avis de recherche", "SUC-05") != 0) return 1;


		if(insertAchievement("CHA-133", "Prime à la chasse", "SUB-039") != 0) return 1;

		if(insertAchievement("QUE-0719", "Commission impossible", "CHA-133") != 0) return 1;
		if(insertAchievement("QUE-0720", "La rançon de la gloire", "CHA-133") != 0) return 1;


		if(insertAchievement("CHA-134", "La rançon de la gloire", "SUB-039") != 0) return 1;

		if(insertAchievement("QUE-0721", "Nourri, logé, blanchi", "CHA-134") != 0) return 1;

		if(insertAchievement("SBQ-1139", "On recherche Fouduglen L''écureuil", "QUE-0721") != 0) return 1;
		if(insertAchievement("SBQ-1140", "On recherche Frakacia Leukocytine", "QUE-0721") != 0) return 1;
		if(insertAchievement("SBQ-1141", "On recherche Ogivol Scalarcin", "QUE-0721") != 0) return 1;
		if(insertAchievement("SBQ-1142", "On recherche Brumen Tinctorias", "QUE-0721") != 0) return 1;
		if(insertAchievement("SBQ-1143", "On recherche Qil Bil", "QUE-0721") != 0) return 1;
		if(insertAchievement("SBQ-1144", "On recherche Padgref Demoël", "QUE-0721") != 0) return 1;

		if(insertAchievement("QUE-0722", "Balle aux prisonniers", "CHA-134") != 0) return 1;

		if(insertAchievement("SBQ-1145", "On recherche Marzwel le Gobelin", "QUE-0722") != 0) return 1;
		if(insertAchievement("SBQ-1146", "On recherche Aermyne ''Braco'' Scalptaras", "QUE-0722") != 0) return 1;
		if(insertAchievement("SBQ-1147", "On recherche Musha l''Oni", "QUE-0722") != 0) return 1;
		if(insertAchievement("SBQ-1148", "On recherche Rok Gnorok", "QUE-0722") != 0) return 1;
		if(insertAchievement("SBQ-1149", "On recherche Zatoïshwan", "QUE-0722") != 0) return 1;

		if(insertAchievement("CHA-135", "Commission impossible", "SUB-039") != 0) return 1;

		if(insertAchievement("QUE-0723", "Une chambre douillette", "CHA-135") != 0) return 1;

		if(insertAchievement("SBQ-1150", "On recherche Bouflouth", "QUE-0723") != 0) return 1;
		if(insertAchievement("SBQ-1151", "On recherche Monsieur Pingouin", "QUE-0723") != 0) return 1;
		if(insertAchievement("SBQ-1152", "On recherche Katigrou", "QUE-0723") != 0) return 1;
		if(insertAchievement("SBQ-1153", "On recherche Fantômayte", "QUE-0723") != 0) return 1;
		if(insertAchievement("SBQ-1154", "On recherche Vengeuse Masquée", "QUE-0723") != 0) return 1;
		if(insertAchievement("SBQ-1155", "On recherche YeCh''Ti", "QUE-0723") != 0) return 1;
		if(insertAchievement("SBQ-1156", "On recherche Docteur Eggob", "QUE-0723") != 0) return 1;

		if(insertAchievement("QUE-0724", "Perdu de recherche", "CHA-135") != 0) return 1;

		if(insertAchievement("SBQ-1157", "On recherche Fuji Givrefoux", "QUE-0724") != 0) return 1;
		if(insertAchievement("SBQ-1158", "On recherche Dremoan", "QUE-0724") != 0) return 1;
		if(insertAchievement("SBQ-1159", "On recherche Flasho", "QUE-0724") != 0) return 1;
		if(insertAchievement("SBQ-1160", "On recherche Viti Glourson", "QUE-0724") != 0) return 1;

		if(insertAchievement("QUE-0725", "L''institut pisteur", "CHA-135") != 0) return 1;

		if(insertAchievement("SBQ-1161", "On recherche Glourdorak", "QUE-0725") != 0) return 1;
		if(insertAchievement("SBQ-1162", "On recherche Mekamouth", "QUE-0725") != 0) return 1;
		if(insertAchievement("SBQ-1163", "On recherche Psikopompe", "QUE-0725") != 0) return 1;
		if(insertAchievement("SBQ-1164", "On recherche Chevalier de Glace", "QUE-0725") != 0) return 1;
		if(insertAchievement("SBQ-1165", "On recherche Culbutoeuf", "QUE-0725") != 0) return 1;
		if(insertAchievement("SBQ-1166", "On recherche le Comte Harebourg", "QUE-0725") != 0) return 1;


		if(insertAchievement("CHA-136", "Justice est faite", "SUB-039") != 0) return 1;


		if(insertAchievement("QUE-0726", "Le plein de super-vilains", "CHA-136") != 0) return 1;

		if(insertAchievement("SBQ-1167", "On recherche Ali Grothor", "QUE-0726") != 0) return 1;
		if(insertAchievement("SBQ-1168", "On recherche les Guman", "QUE-0726") != 0) return 1;
		if(insertAchievement("SBQ-1169", "On recherche Gadoo", "QUE-0726") != 0) return 1;
		if(insertAchievement("SBQ-1170", "On recherche Amy l''Empoisonneuse", "QUE-0726") != 0) return 1;
		if(insertAchievement("SBQ-1171", "On recherche l''Hyperscampe", "QUE-0726") != 0) return 1;

		if(insertAchievement("QUE-0727", "Dimension carcérale", "CHA-136") != 0) return 1;

		if(insertAchievement("SBQ-1172", "On recherche la Maxi-Malle", "QUE-0727") != 0) return 1;
		if(insertAchievement("SBQ-1173", "On recherche Aigripoil", "QUE-0727") != 0) return 1;
		if(insertAchievement("SBQ-1174", "On recherche Voldelor", "QUE-0727") != 0) return 1;
		if(insertAchievement("SBQ-1175", "On recherche Gein", "QUE-0727") != 0) return 1;
		if(insertAchievement("SBQ-1176", "On recherche la Mouchâme", "QUE-0727") != 0) return 1;
		if(insertAchievement("SBQ-1177", "On recherche Pantèroz", "QUE-0727") != 0) return 1;
		if(insertAchievement("SBQ-1178", "On recherche Morblok", "QUE-0727") != 0) return 1;
		if(insertAchievement("SBQ-1179", "On recherche Hin", "QUE-0727") != 0) return 1;
		if(insertAchievement("SBQ-1180", "On recherche Sicogne", "QUE-0727") != 0) return 1;

		if(insertAchievement("QUE-0728", "Les sept saloupiots", "CHA-136") != 0) return 1;

		if(insertAchievement("SBQ-1181", "On recherche Tyranne la Terrible", "QUE-0728") != 0) return 1;
		if(insertAchievement("SBQ-1182", "On recherche Naganita", "QUE-0728") != 0) return 1;
		if(insertAchievement("SBQ-1183", "On recherche Nenufor Tilotus", "QUE-0728") != 0) return 1;
		if(insertAchievement("SBQ-1184", "On recherche Fojumo", "QUE-0728") != 0) return 1;
		if(insertAchievement("SBQ-1185", "On recherche Anatak Diskedor", "QUE-0728") != 0) return 1;
		if(insertAchievement("SBQ-1186", "On recherche le Guerrier du K.O.", "QUE-0728") != 0) return 1;
		if(insertAchievement("SBQ-1187", "On recherche le Grand Kongoku", "QUE-0728") != 0) return 1;


		if(insertAchievement("SUB-040", "Alignement", "SUC-05") != 0) return 1;


		if(insertAchievement("CHA-137", "Garde à vous", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-138", "Alignement niveau 10", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-139", "Chef oui chef", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-140", "Alignement niveau 20", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-141", "Adjugé glandu", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-142", "Alignement niveau 30", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-143", "Major de promotion canapé", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-144", "Alignement niveau 40", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-145", "Aspirateur", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-146", "Alignement niveau 50", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-147", "Lieutenant Colon", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-148", "Alignement niveau 60", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-149", "Ohé, ohé, capitaine abandonné", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-150", "Alignement niveau 70", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-151", "Commande et ment", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-152", "Alignement niveau 80", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-153", "Colonel Chachabert", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-154", "Alignement niveau 90", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-155", "À vos Ordres!", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-156", "Premier rang dans un Ordre", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-157", "Mot d''Ordre", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-158", "Premier rang dans un Ordre", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-159", "Jusqu''à nouvel Ordre", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-160", "Deuxième rang dans un Ordre", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-161", "Ordre du jour", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-162", "Deuxième rang dans un Ordre", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-163", "Maintien de l''Ordre", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-164", "Troisième rang dans un Ordre", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-165", "Mettre en Ordre", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-166", "Troisième rang dans un Ordre", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-167", "Tout est en Ordre", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-168", "Quatrième rang dans un Ordre", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-169", "Dans l''Ordre des choses", "SUB-040") != 0) return 1;

		if(insertAchievement("CHA-170", "Quatrième rang dans un Ordre", "SUB-040") != 0) return 1;



		if(insertAchievement("SUB-041", "Dimensions Divines", "SUC-05") != 0) return 1;



		if(insertAchievement("CHA-171", "Je rêvais d''un autre monde", "SUB-041") != 0) return 1;

		if(insertAchievement("QUE-0729", "Le pays de des Vermeils", "CHA-171") != 0) return 1;
		if(insertAchievement("QUE-0730", "Le royaume des ombres", "CHA-171") != 0) return 1;
		if(insertAchievement("QUE-0731", "Le domaine des possibles", "CHA-171") != 0) return 1;
		if(insertAchievement("QUE-0732", "Odyssée en trois dimensions", "CHA-171") != 0) return 1;
		if(insertAchievement("QUE-0733", "La quête de l''oiseau du temps", "CHA-171") != 0) return 1;

		if(insertAchievement("CHA-172", "Le pays des Vermeils", "SUB-041") != 0) return 1;


		if(insertAchievement("QUE-0734", "Même pas malle", "CHA-172") != 0) return 1;

		if(insertAchievement("SBQ-1188", "Elle va finir par se faire coffrer", "QUE-0734") != 0) return 1;
		if(insertAchievement("SBQ-1189", "Pompe à fric", "QUE-0734") != 0) return 1;
		if(insertAchievement("SBQ-1190", "Koffrologie", "QUE-0734") != 0) return 1;
		if(insertAchievement("SBQ-1191", "Trésorphelinat", "QUE-0734") != 0) return 1;
		if(insertAchievement("SBQ-1192", "Malladie", "QUE-0734") != 0) return 1;

		if(insertAchievement("QUE-0735", "Après les phorreurs, le réconfort", "CHA-172") != 0) return 1;

		if(insertAchievement("SBQ-1193", "Crache Test", "QUE-0735") != 0) return 1;
		if(insertAchievement("SBQ-1194", "La quatrième dimension", "QUE-0735") != 0) return 1;
		if(insertAchievement("SBQ-1195", "Déphorrestation", "QUE-0735") != 0) return 1;
		if(insertAchievement("SBQ-1196", "La meilleur défense, c''est l''attaque", "QUE-0735") != 0) return 1;
		if(insertAchievement("SBQ-1197", "Phorreurs dans la brume", "QUE-0735") != 0) return 1;
		if(insertAchievement("SBQ-1198", "Le phormidiable au corps", "QUE-0735") != 0) return 1;
		if(insertAchievement("SBQ-1199", "La pelle de la phorrée", "QUE-0735") != 0) return 1;
		if(insertAchievement("SBQ-1200", "Les grandes galeries", "QUE-0735") != 0) return 1;
		if(insertAchievement("SBQ-1201", "Un coeur d''or", "QUE-0735") != 0) return 1;
		if(insertAchievement("SBQ-1202", "Maudite générosité", "QUE-0735") != 0) return 1;

		if(insertAchievement("QUE-0736", "Le roi et moi", "CHA-172") != 0) return 1;

		if(insertAchievement("SBQ-1203", "On ne prête qu''à Richard", "QUE-0736") != 0) return 1;
		if(insertAchievement("SBQ-1204", "Pour quelques kamas de plus", "QUE-0736") != 0) return 1;
		if(insertAchievement("SBQ-1205", "Tout ce qui brille n''est pas or", "QUE-0736") != 0) return 1;
		if(insertAchievement("SBQ-1206", "Un morceau de roi", "QUE-0736") != 0) return 1;
		if(insertAchievement("SBQ-1207", "Prime de lèche-majesté", "QUE-0736") != 0) return 1;
		if(insertAchievement("SBQ-1208", "Coiffeur de génie", "QUE-0736") != 0) return 1;


		if(insertAchievement("QUE-0737", "Raisons de retraite", "CHA-172") != 0) return 1;

		if(insertAchievement("SBQ-1209", "Touchez pas à Grisebigle", "QUE-0737") != 0) return 1;
		if(insertAchievement("SBQ-1210", "Échantillonnage", "QUE-0737") != 0) return 1;
		if(insertAchievement("SBQ-1211", "Le silence est d''or", "QUE-0737") != 0) return 1;
		if(insertAchievement("SBQ-1212", "Espionnage industriel", "QUE-0737") != 0) return 1;
		if(insertAchievement("SBQ-1213", "Prise d''otages", "QUE-0737") != 0) return 1;
		if(insertAchievement("SBQ-1214", "La grève de la fin", "QUE-0737") != 0) return 1;
		if(insertAchievement("SBQ-1215", "Malle des profondeurs", "QUE-0737") != 0) return 1;
		if(insertAchievement("SBQ-1216", "Reconnaissance de dettes", "QUE-0737") != 0) return 1;
		if(insertAchievement("SBQ-1217", "Laissé en plan", "QUE-0737") != 0) return 1;

		if(insertAchievement("QUE-0738", "Parler au dieu Enutrof", "CHA-172") != 0) return 1;



		if(insertAchievement("CHA-173", "Le royaume des ombres", "SUB-041") != 0) return 1;


		if(insertAchievement("QUE-0739", "Sauvé par le gong", "CHA-173") != 0) return 1;

		if(insertAchievement("SBQ-1218", "Ça katche ou ça casse", "QUE-0739") != 0) return 1;
		if(insertAchievement("SBQ-1219", "Fanfouille", "QUE-0739") != 0) return 1;
		if(insertAchievement("SBQ-1220", "La seinoise", "QUE-0739") != 0) return 1;
		if(insertAchievement("SBQ-1221", "Ça se katche", "QUE-0739") != 0) return 1;
		if(insertAchievement("SBQ-1222", "Un ring pour les gouverner tous", "QUE-0739") != 0) return 1;


		if(insertAchievement("QUE-0740", "Crache ton venin", "CHA-173") != 0) return 1;

		if(insertAchievement("SBQ-1223", "Nécrotiques, tiques, tiques", "QUE-0740") != 0) return 1;
		if(insertAchievement("SBQ-1224", "La pêche au poison", "QUE-0740") != 0) return 1;
		if(insertAchievement("SBQ-1225", "Les troupiers", "QUE-0740") != 0) return 1;
		if(insertAchievement("SBQ-1226", "Épidémiologie", "QUE-0740") != 0) return 1;
		if(insertAchievement("SBQ-1227", "Tique attaque", "QUE-0740") != 0) return 1;
		if(insertAchievement("SBQ-1228", "Sa majesté des Nécrotiques", "QUE-0740") != 0) return 1;
		if(insertAchievement("SBQ-1229", "L''art me ment", "QUE-0740") != 0) return 1;
		if(insertAchievement("SBQ-1230", "Viande fraîche", "QUE-0740") != 0) return 1;
		if(insertAchievement("SBQ-1231", "La morte Adèle", "QUE-0740") != 0) return 1;
		if(insertAchievement("SBQ-1232", "Comme un poison dans l''eau", "QUE-0740") != 0) return 1;

		if(insertAchievement("QUE-0741", "Le jeu du trône", "CHA-173") != 0) return 1;

		if(insertAchievement("SBQ-1233", "Les sentiers de la perdition", "QUE-0741") != 0) return 1;
		if(insertAchievement("SBQ-1234", "Le Bazar du Bizarre", "QUE-0741") != 0) return 1;
		if(insertAchievement("SBQ-1235", "Un chafer dans le placard", "QUE-0741") != 0) return 1;
		if(insertAchievement("SBQ-1236", "Bouchées à la reine", "QUE-0741") != 0) return 1;
		if(insertAchievement("SBQ-1237", "La cour des miracles", "QUE-0741") != 0) return 1;
		if(insertAchievement("SBQ-1238", "Os sitôt dit, aussitôt fait", "QUE-0741") != 0) return 1;


		if(insertAchievement("QUE-0742", "Les voleurs de Srambad", "CHA-173") != 0) return 1;

		if(insertAchievement("SBQ-1239", "Faux-semblants", "QUE-0742") != 0) return 1;
		if(insertAchievement("SBQ-1240", "Mémoires d''outre-tombe", "QUE-0742") != 0) return 1;
		if(insertAchievement("SBQ-1241", "Balance la sauce", "QUE-0742") != 0) return 1;
		if(insertAchievement("SBQ-1242", "La chapelle noire", "QUE-0742") != 0) return 1;
		if(insertAchievement("SBQ-1243", "Présumé coupable", "QUE-0742") != 0) return 1;
		if(insertAchievement("SBQ-1244", "Depuis l''enfer", "QUE-0742") != 0) return 1;
		if(insertAchievement("SBQ-1245", "Courir après des ombres", "QUE-0742") != 0) return 1;
		if(insertAchievement("SBQ-1246", "Sortir de l''ombre", "QUE-0742") != 0) return 1;
		if(insertAchievement("SBQ-1247", "La grosse commission", "QUE-0742") != 0) return 1;

		if(insertAchievement("QUE-0743", "Parler au dieu Sram", "CHA-173") != 0) return 1;


		if(insertAchievement("CHA-174", "Le domaine des possibles", "SUB-041") != 0) return 1;

		if(insertAchievement("QUE-0744", "Les temps qui courent", "CHA-174") != 0) return 1;

		if(insertAchievement("SBQ-1248", "Anomalies temporelles", "QUE-0744") != 0) return 1;
		if(insertAchievement("SBQ-1249", "C''est ton destin", "QUE-0744") != 0) return 1;
		if(insertAchievement("SBQ-1250", "Retour vers le présent", "QUE-0744") != 0) return 1;
		if(insertAchievement("SBQ-1251", "Prisonniers du temps", "QUE-0744") != 0) return 1;


		if(insertAchievement("QUE-0745", "Carpe Diem", "CHA-174") != 0) return 1;

		if(insertAchievement("SBQ-1252", "Les voleurs de couleurs", "QUE-0745") != 0) return 1;
		if(insertAchievement("SBQ-1253", "Terminutor: le jugement de la machine", "QUE-0745") != 0) return 1;
		if(insertAchievement("SBQ-1254", "Les démons de midi", "QUE-0745") != 0) return 1;
		if(insertAchievement("SBQ-1255", "Aux origines du mal", "QUE-0745") != 0) return 1;
		if(insertAchievement("SBQ-1256", "De fil en aiguille", "QUE-0745") != 0) return 1;
		if(insertAchievement("SBQ-1257", "La Vie, l''Hormonde et le Reste", "QUE-0745") != 0) return 1;
		if(insertAchievement("SBQ-1258", "Failles spatio-temporelles", "QUE-0745") != 0) return 1;
		if(insertAchievement("SBQ-1259", "C''est quoi ton 60?", "QUE-0745") != 0) return 1;
		if(insertAchievement("SBQ-1260", "Aujourd''hui à jamais", "QUE-0745") != 0) return 1;
		if(insertAchievement("SBQ-1261", "Tout ce qu''il te faut, c''est tuer", "QUE-0745") != 0) return 1;


		if(insertAchievement("QUE-0746", "Le puits du fou", "CHA-174") != 0) return 1;

		if(insertAchievement("SBQ-1262", "Juste une illusion", "QUE-0746") != 0) return 1;
		if(insertAchievement("SBQ-1263", "Maboul de cristal", "QUE-0746") != 0) return 1;
		if(insertAchievement("SBQ-1264", "L''armée des 12 dingues", "QUE-0746") != 0) return 1;
		if(insertAchievement("SBQ-1265", "La vérité est au fond du puits", "QUE-0746") != 0) return 1;
		if(insertAchievement("SBQ-1266", "Les sables du temps", "QUE-0746") != 0) return 1;


		if(insertAchievement("QUE-0747", "Moments d''égarement", "CHA-174") != 0) return 1;

		if(insertAchievement("SBQ-1267", "Déchirures temporelles", "QUE-0747") != 0) return 1;
		if(insertAchievement("SBQ-1268", "Futur antérieur", "QUE-0747") != 0) return 1;
		if(insertAchievement("SBQ-1269", "Guerre temporelle", "QUE-0747") != 0) return 1;
		if(insertAchievement("SBQ-1270", "L''étendue Gödelique", "QUE-0747") != 0) return 1;
		if(insertAchievement("SBQ-1271", "Les visiteurs du futur", "QUE-0747") != 0) return 1;
		if(insertAchievement("SBQ-1272", "Demain ne meurt jamais", "QUE-0747") != 0) return 1;

		if(insertAchievement("QUE-0748", "Parler au dieu Xélor", "CHA-174") != 0) return 1;

		if(insertAchievement("CHA-175", "Les contrées du hasard", "SUB-041") != 0) return 1;

		if(insertAchievement("QUE-0749", "Tu peux toujours te gratter", "CHA-175") != 0) return 1;

		if(insertAchievement("SBQ-1273", "Ça saute aux oeufs", "QUE-0749") != 0) return 1;
		if(insertAchievement("SBQ-1274", "Puce de luxe", "QUE-0749") != 0) return 1;
		if(insertAchievement("SBQ-1275", "Acides animés", "QUE-0749") != 0) return 1;
		if(insertAchievement("SBQ-1276", "Faut pas pousser", "QUE-0749") != 0) return 1;
		if(insertAchievement("SBQ-1277", "Testé et approuvé", "QUE-0749") != 0) return 1;


		if(insertAchievement("QUE-0750", "Angoraphobie", "CHA-175") != 0) return 1;

		if(insertAchievement("SBQ-1278", "Sanctuaires de famille", "QUE-0750") != 0) return 1;
		if(insertAchievement("SBQ-1279", "Le jeu du Chaminou", "QUE-0750") != 0) return 1;
		if(insertAchievement("SBQ-1280", "De mauvais poil", "QUE-0750") != 0) return 1;
		if(insertAchievement("SBQ-1281", "L''As du Volans", "QUE-0750") != 0) return 1;
		if(insertAchievement("SBQ-1282", "En rouge et noir", "QUE-0750") != 0) return 1;
		if(insertAchievement("SBQ-1283", "Tu peux te brosser", "QUE-0750") != 0) return 1;
		if(insertAchievement("SBQ-1284", "GaBuZoMeu", "QUE-0750") != 0) return 1;
		if(insertAchievement("SBQ-1285", "Où est Charblie?", "QUE-0750") != 0) return 1;
		if(insertAchievement("SBQ-1286", "La chance aux chanceux", "QUE-0750") != 0) return 1;


		if(insertAchievement("QUE-0751", "On va tout défausser", "CHA-175") != 0) return 1;

		if(insertAchievement("SBQ-1287", "Dimensions absurdes", "QUE-0751") != 0) return 1;
		if(insertAchievement("SBQ-1288", "Une parodie de jeustice", "QUE-0751") != 0) return 1;
		if(insertAchievement("SBQ-1289", "De l''autre côté du Chaloeil", "QUE-0751") != 0) return 1;
		if(insertAchievement("SBQ-1290", "Le conquérant", "QUE-0751") != 0) return 1;
		if(insertAchievement("SBQ-1291", "Karkass mania", "QUE-0751") != 0) return 1;
		if(insertAchievement("SBQ-1292", "Il s''en est fallu d''un poil", "QUE-0751") != 0) return 1;
		if(insertAchievement("SBQ-1293", "Se piquer au jeu", "QUE-0751") != 0) return 1;

		if(insertAchievement("QUE-0752", "Parler au dieu Ecaflip", "CHA-175") != 0) return 1;



		if(insertAchievement("SUB-042", "Justiciers", "SUC-05") != 0) return 1;



		if(insertAchievement("CHA-176", "Diplôme de Justicier", "SUB-042") != 0) return 1;


		if(insertAchievement("QUE-0753", "Ca va faire du vilain", "CHA-176") != 0) return 1;

		if(insertAchievement("SBQ-1294", "Protéger et sévir", "QUE-0753") != 0) return 1;
		if(insertAchievement("SBQ-1295", "Quelque chose de pourri au royaume d''Amakna", "QUE-0753") != 0) return 1;
		if(insertAchievement("SBQ-1296", "Ainsi font les petites marionnettes", "QUE-0753") != 0) return 1;
		if(insertAchievement("SBQ-1297", "L''armée des ombres", "QUE-0753") != 0) return 1;
		if(insertAchievement("SBQ-1298", "Pollution, je dis non", "QUE-0753") != 0) return 1;


		if(insertAchievement("QUE-0754", "Bizutage", "CHA-176") != 0) return 1;

		if(insertAchievement("SBQ-1299", "Recrue explosive", "QUE-0754") != 0) return 1;
		if(insertAchievement("SBQ-1300", "Recrue brigandine", "QUE-0754") != 0) return 1;
		if(insertAchievement("SBQ-1301", "Recrue assoiffée", "QUE-0754") != 0) return 1;
		if(insertAchievement("SBQ-1302", "Recrue lugubre", "QUE-0754") != 0) return 1;
		if(insertAchievement("SBQ-1303", "Recrue emballée", "QUE-0754") != 0) return 1;
		if(insertAchievement("SBQ-1304", "Recrue princière", "QUE-0754") != 0) return 1;


		if(insertAchievement("QUE-0755", "Formation pratique", "CHA-176") != 0) return 1;

		if(insertAchievement("SBQ-1305", "Formation des première année", "QUE-0755") != 0) return 1;
		if(insertAchievement("SBQ-1306", "Formation des deuxième année", "QUE-0755") != 0) return 1;
		if(insertAchievement("SBQ-1307", "Formation des troisième année", "QUE-0755") != 0) return 1;
		if(insertAchievement("SBQ-1308", "Formation des quatrième année", "QUE-0755") != 0) return 1;
		if(insertAchievement("SBQ-1309", "Formation des cinquième année", "QUE-0755") != 0) return 1;
		if(insertAchievement("SBQ-1310", "Formation des sixième année", "QUE-0755") != 0) return 1;
		if(insertAchievement("SBQ-1311", "Formation des septième année", "QUE-0755") != 0) return 1;
		if(insertAchievement("SBQ-1312", "Formation des huitième année", "QUE-0755") != 0) return 1;
		if(insertAchievement("SBQ-1313", "Formation des neuvième année", "QUE-0755") != 0) return 1;
		if(insertAchievement("SBQ-1314", "Formation des dixième année", "QUE-0755") != 0) return 1;


		if(insertAchievement("QUE-0756", "Nouvelle fournée de Justiciers", "CHA-176") != 0) return 1;

		if(insertAchievement("SBQ-1315", "Stage de combat improvisé", "QUE-0756") != 0) return 1;
		if(insertAchievement("SBQ-1316", "Apprentissage en tirage d''oreilles", "QUE-0756") != 0) return 1;
		if(insertAchievement("SBQ-1317", "Licence en distribution de pains", "QUE-0756") != 0) return 1;
		if(insertAchievement("SBQ-1318", "Maîtrise en flanquage de rouste", "QUE-0756") != 0) return 1;
		if(insertAchievement("SBQ-1319", "Doctorat en bottage de fesses", "QUE-0756") != 0) return 1;

		if(insertAchievement("CHA-177", "Autres", "SUB-042") != 0) return 1;



		if(insertAchievement("QUE-0757", "Mort ou vif", "CHA-177") != 0) return 1;

		if(insertAchievement("SBQ-1320", "Les Guman", "QUE-0757") != 0) return 1;
		if(insertAchievement("SBQ-1321", "Gadoo", "QUE-0757") != 0) return 1;
		if(insertAchievement("SBQ-1322", "Amy l''empoisonneuse", "QUE-0757") != 0) return 1;
		if(insertAchievement("SBQ-1323", "Hyperscampe", "QUE-0757") != 0) return 1;
		if(insertAchievement("SBQ-1324", "Dramak", "QUE-0757") != 0) return 1;
		if(insertAchievement("SBQ-1325", "Ombre", "QUE-0757") != 0) return 1;
		if(insertAchievement("SBQ-1326", "Merkator", "QUE-0757") != 0) return 1;
		if(insertAchievement("SBQ-1327", "Nileza", "QUE-0757") != 0) return 1;
		if(insertAchievement("SBQ-1328", "Sylargh", "QUE-0757") != 0) return 1;
		if(insertAchievement("SBQ-1329", "Klime", "QUE-0757") != 0) return 1;
		if(insertAchievement("SBQ-1330", "Missiz Frizz", "QUE-0757") != 0) return 1;
		if(insertAchievement("SBQ-1331", "Comte Harebourg", "QUE-0757") != 0) return 1;



		if(insertAchievement("SUB-043", "Krosmoz", "SUC-05") != 0) return 1;


		if(insertAchievement("CHA-178", "Autres", "SUB-043") != 0) return 1;


		if(insertAchievement("QUE-0758", "L''osmose", "CHA-178") != 0) return 1;

		if(insertAchievement("SBQ-1332", "La fin du règne", "QUE-0758") != 0) return 1;
		if(insertAchievement("SBQ-1333", "Mieux vaut ne pas se fier à la première impression", "QUE-0758") != 0) return 1;
		if(insertAchievement("SBQ-1334", "Attention à la Bête!", "QUE-0758") != 0) return 1;
		if(insertAchievement("SBQ-1335", "À la recherche des instants perdus", "QUE-0758") != 0) return 1;
		if(insertAchievement("SBQ-1336", "Guewwe et Paix", "QUE-0758") != 0) return 1;
		if(insertAchievement("SBQ-1337", "Où est passée la 7e compagnie?", "QUE-0758") != 0) return 1;
		if(insertAchievement("SBQ-1338", "Du rire en barre", "QUE-0758") != 0) return 1;

		if(insertAchievement("QUE-0759", "Faire le keke", "CHA-178") != 0) return 1;

		if(insertAchievement("SBQ-1339", "Scène de ménage", "QUE-0759") != 0) return 1;
		if(insertAchievement("SBQ-1340", "Shushu et Lulu", "QUE-0759") != 0) return 1;
		if(insertAchievement("SBQ-1341", "Bien velu, c''est Kerubim", "QUE-0759") != 0) return 1;



		if(insertAchievement("SUB-044", "Astrub", "SUC-05") != 0) return 1;


		if(insertAchievement("CHA-179", "Astrub a un incroyable talent", "SUB-044") != 0) return 1;


		if(insertAchievement("QUE-0760", "Astrub ô mon pays", "CHA-179") != 0) return 1;

		if(insertAchievement("SBQ-1342", "Un touriste averti en vaut deux.", "QUE-0760") != 0) return 1;
		if(insertAchievement("SBQ-1343", "Mastrubation.", "QUE-0760") != 0) return 1;
		if(insertAchievement("SBQ-1344", "Écouter aux portes.", "QUE-0760") != 0) return 1;
		if(insertAchievement("SBQ-1345", "La ballade des Astrubiens heureux.", "QUE-0760") != 0) return 1;
		if(insertAchievement("SBQ-1346", "Visite guidée au château d''Allister", "QUE-0760") != 0) return 1;
		if(insertAchievement("SBQ-1347", "Les gens du village.", "QUE-0760") != 0) return 1;

		if(insertAchievement("QUE-0761", "Astrub history X", "CHA-179") != 0) return 1;

		if(insertAchievement("SBQ-1348", "Le live d''Acidrik Fenlapanse", "QUE-0761") != 0) return 1;
		if(insertAchievement("SBQ-1349", "Tout finit par une bonne bière", "QUE-0761") != 0) return 1;
		if(insertAchievement("SBQ-1350", "Saint de corps et d''esprits", "QUE-0761") != 0) return 1;
		if(insertAchievement("SBQ-1351", "Le prêtre et la tête de Menalt", "QUE-0761") != 0) return 1;
		if(insertAchievement("SBQ-1352", "La genèse d''un royaume", "QUE-0761") != 0) return 1;

		if(insertAchievement("QUE-0762", "Baston", "CHA-179") != 0) return 1;

		if(insertAchievement("SBQ-1353", "Wambo des bacs à sable.", "QUE-0762") != 0) return 1;
		if(insertAchievement("SBQ-1354", "Les prisonniers d''Astrub", "QUE-0762") != 0) return 1;
		if(insertAchievement("SBQ-1355", "De terre et de crocs.", "QUE-0762") != 0) return 1;
		if(insertAchievement("SBQ-1356", "Ça bosse dur.", "QUE-0762") != 0) return 1;
		if(insertAchievement("SBQ-1357", "Tire laine", "QUE-0762") != 0) return 1;
		if(insertAchievement("SBQ-1358", "La Tête dans le sable.", "QUE-0762") != 0) return 1;
		if(insertAchievement("SBQ-1359", "Les Fleurs du mal.", "QUE-0762") != 0) return 1;
		if(insertAchievement("SBQ-1360", "Un conflit manichéen.", "QUE-0762") != 0) return 1;
		if(insertAchievement("SBQ-1361", "Héros de pacotille.", "QUE-0762") != 0) return 1;

		if(insertAchievement("QUE-0763", "Pôle emploi", "CHA-179") != 0) return 1;

		if(insertAchievement("SBQ-1362", "Récolter dans semer.", "QUE-0763") != 0) return 1;
		if(insertAchievement("SBQ-1363", "Art culinaire.", "QUE-0763") != 0) return 1;
		if(insertAchievement("SBQ-1364", "L''arme à Guédon", "QUE-0763") != 0) return 1;
		if(insertAchievement("SBQ-1365", "Prêt-à-porter.", "QUE-0763") != 0) return 1;
		if(insertAchievement("SBQ-1366", "La clef de la réussite.", "QUE-0763") != 0) return 1;
		if(insertAchievement("SBQ-1367", "Les bons conseils d''Hel Munster.", "QUE-0763") != 0) return 1;

		if(insertAchievement("QUE-0764", "Les miséroïdes", "CHA-179") != 0) return 1;

		if(insertAchievement("SBQ-1368", "La complainte du Chacha", "QUE-0764") != 0) return 1;
		if(insertAchievement("SBQ-1369", "Chasse à l''écureuil", "QUE-0764") != 0) return 1;
		if(insertAchievement("SBQ-1370", "Les citwouilles sont-elles cuites?", "QUE-0764") != 0) return 1;
		if(insertAchievement("SBQ-1371", "Pleur Nycheuz", "QUE-0764") != 0) return 1;
		if(insertAchievement("SBQ-1372", "Grain de folie à Astrub", "QUE-0764") != 0) return 1;
		if(insertAchievement("SBQ-1373", "Bière en danger", "QUE-0764") != 0) return 1;
		if(insertAchievement("SBQ-1374", "Ne pas vendre la mèche avant de l''avoir tuée", "QUE-0764") != 0) return 1;


		if(insertAchievement("QUE-0765", "Les branquignoles", "CHA-179") != 0) return 1;

		if(insertAchievement("SBQ-1375", "Problème de livraison", "QUE-0765") != 0) return 1;
		if(insertAchievement("SBQ-1376", "Vol... Age?", "QUE-0765") != 0) return 1;
		if(insertAchievement("SBQ-1377", "La discorde végétale", "QUE-0765") != 0) return 1;
		if(insertAchievement("SBQ-1378", "De la difficulté à être Bijoutier", "QUE-0765") != 0) return 1;
		if(insertAchievement("SBQ-1379", "Un ours dans la bouftonerie", "QUE-0765") != 0) return 1;
		if(insertAchievement("SBQ-1380", "La dernière mode", "QUE-0765") != 0) return 1;

		if(insertAchievement("QUE-0766", "Cultures et moisissures", "CHA-179") != 0) return 1;

		if(insertAchievement("SBQ-1381", "Nourrir la plèbe.", "QUE-0766") != 0) return 1;
		if(insertAchievement("SBQ-1382", "À manger pour tous.", "QUE-0766") != 0) return 1;
		if(insertAchievement("SBQ-1383", "Santho le mytho.", "QUE-0766") != 0) return 1;
		if(insertAchievement("SBQ-1384", "Ça sent le moisi.", "QUE-0766") != 0) return 1;
		if(insertAchievement("SBQ-1385", "Céréale killeur.", "QUE-0766") != 0) return 1;


		if(insertAchievement("SUB-045", "Campement des Bworks", "SUC-05") != 0) return 1;



		if(insertAchievement("CHA-180", "Autres", "SUB-045") != 0) return 1;


		if(insertAchievement("QUE-0767", "Le théâtre des gobelins", "CHA-180") != 0) return 1;

		if(insertAchievement("SBQ-1386", "Les Gobelins de la Manufacture", "QUE-0767") != 0) return 1;
		if(insertAchievement("SBQ-1387", "Gobmichet vibre pour Gobrose", "QUE-0767") != 0) return 1;
		if(insertAchievement("SBQ-1388", "Ange de Gobriel", "QUE-0767") != 0) return 1;
		if(insertAchievement("SBQ-1389", "Titi Gobelait le magobelin", "QUE-0767") != 0) return 1;
		if(insertAchievement("SBQ-1390", "Manque de moule", "QUE-0767") != 0) return 1;
		if(insertAchievement("SBQ-1391", "Un avenir de krotte de Trooll", "QUE-0767") != 0) return 1;


		if(insertAchievement("QUE-0768", "Kaïra", "CHA-180") != 0) return 1;

		if(insertAchievement("SBQ-1392", "Pinta Gone veut se remplir de bière Bwork", "QUE-0768") != 0) return 1;
		if(insertAchievement("SBQ-1393", "Bienvenue au Krazybwork saloon", "QUE-0768") != 0) return 1;
		if(insertAchievement("SBQ-1394", "Bworkidais le paxifik", "QUE-0768") != 0) return 1;
		if(insertAchievement("SBQ-1395", "Manque de peaux", "QUE-0768") != 0) return 1;
		if(insertAchievement("SBQ-1396", "Une baguette pour Chef Bworkestre", "QUE-0768") != 0) return 1;



		if(insertAchievement("SUB-046", "Cania", "SUC-05") != 0) return 1;



		if(insertAchievement("CHA-181", "Autres", "SUB-046") != 0) return 1;


		if(insertAchievement("QUE-0769", "La voyageuse imprudente", "CHA-181") != 0) return 1;

		if(insertAchievement("SBQ-1397", "L''accusé de la réception", "QUE-0769") != 0) return 1;
		if(insertAchievement("SBQ-1398", "Les monstres aboient, la diligence casse", "QUE-0769") != 0) return 1;
		if(insertAchievement("SBQ-1399", "Chachyène de vie", "QUE-0769") != 0) return 1;
		if(insertAchievement("SBQ-1400", "Où que les bêtes aillent", "QUE-0769") != 0) return 1;
		if(insertAchievement("SBQ-1401", "Niera bien qui niera le dernier", "QUE-0769") != 0) return 1;
		if(insertAchievement("SBQ-1402", "Remède miracle", "QUE-0769") != 0) return 1;
		if(insertAchievement("SBQ-1403", "L''art triste", "QUE-0769") != 0) return 1;
		if(insertAchievement("SBQ-1404", "Un mâle et fils", "QUE-0769") != 0) return 1;
		if(insertAchievement("SBQ-1405", "Boulétisation", "QUE-0769") != 0) return 1;

		if(insertAchievement("QUE-0770", "Caniablanca", "CHA-181") != 0) return 1;

		if(insertAchievement("SBQ-1406", "La foire aux gobs", "QUE-0770") != 0) return 1;
		if(insertAchievement("SBQ-1407", "Grouiiik!", "QUE-0770") != 0) return 1;
		if(insertAchievement("SBQ-1408", "La tribu pas si fixe", "QUE-0770") != 0) return 1;
		if(insertAchievement("SBQ-1409", "La mécanique du corps", "QUE-0770") != 0) return 1;
		if(insertAchievement("SBQ-1410", "Le champ de la mer", "QUE-0770") != 0) return 1;
		if(insertAchievement("SBQ-1411", "Les cailloux de Cania", "QUE-0770") != 0) return 1;
		if(insertAchievement("SBQ-1412", "Le quiproquo", "QUE-0770") != 0) return 1;
		if(insertAchievement("SBQ-1413", "Le triomphe de la médecine", "QUE-0770") != 0) return 1;

		if(insertAchievement("QUE-0771", "Ça en valait la plaine", "CHA-181") != 0) return 1;

		if(insertAchievement("SBQ-1414", "Oiseau de mauvais augure", "QUE-0771") != 0) return 1;
		if(insertAchievement("SBQ-1415", "Voler dans les plumes", "QUE-0771") != 0) return 1;
		if(insertAchievement("SBQ-1416", "Jeu de Trooll", "QUE-0771") != 0) return 1;
		if(insertAchievement("SBQ-1417", "Frankenstruche", "QUE-0771") != 0) return 1;
		if(insertAchievement("SBQ-1418", "Au temps l''emportent les landes", "QUE-0771") != 0) return 1;



		if(insertAchievement("SUB-047", "Château d''Amakna", "SUC-05") != 0) return 1;



		if(insertAchievement("CHA-182", "Autres", "SUB-047") != 0) return 1;


		if(insertAchievement("QUE-0772", "Le vallon du château", "CHA-182") != 0) return 1;

		if(insertAchievement("SBQ-1419", "Pauvre pomme (de terre)", "QUE-0772") != 0) return 1;
		if(insertAchievement("SBQ-1420", "Gros oeuvres au château d''Allister", "QUE-0772") != 0) return 1;
		if(insertAchievement("SBQ-1421", "Kartier Tremai se met à table", "QUE-0772") != 0) return 1;



		if(insertAchievement("SUB-048", "Île de Frigost", "SUC-05") != 0) return 1;



		if(insertAchievement("CHA-183", "C''est l''heure de faire le comte", "SUB-048") != 0) return 1;

		if(insertAchievement("QUE-0773", "Fri carré", "CHA-183") != 0) return 1;
		if(insertAchievement("QUE-0774", "Halte au péage", "CHA-183") != 0) return 1;
		if(insertAchievement("QUE-0775", "La maire dénie", "CHA-183") != 0) return 1;
		if(insertAchievement("QUE-0776", "D''hiver et varié", "CHA-183") != 0) return 1;
		if(insertAchievement("QUE-0777", "Activités frigostiennes", "CHA-183") != 0) return 1;
		if(insertAchievement("QUE-0778", "Des trucs inutiles", "CHA-183") != 0) return 1;


		if(insertAchievement("CHA-184", "L''ère glaciaire", "SUB-048") != 0) return 1;

		if(insertAchievement("QUE-0779", "Un songe en hiver", "CHA-184") != 0) return 1;
		if(insertAchievement("QUE-0780", "À cause des glaçons", "CHA-184") != 0) return 1;
		if(insertAchievement("QUE-0781", "Des trucs sans intérêt", "CHA-184") != 0) return 1;


		if(insertAchievement("CHA-185", "D''hiver et varié", "SUB-048") != 0) return 1;


		if(insertAchievement("QUE-0782", "Jouer au docteur", "CHA-185") != 0) return 1;

		if(insertAchievement("SBQ-1422", "Les monologues du vaccin.", "QUE-0782") != 0) return 1;
		if(insertAchievement("SBQ-1423", "Épis d''Emi.", "QUE-0782") != 0) return 1;
		if(insertAchievement("SBQ-1424", "Le mal a dit.", "QUE-0782") != 0) return 1;
		if(insertAchievement("SBQ-1425", "Convoi humanitaire.", "QUE-0782") != 0) return 1;
		if(insertAchievement("SBQ-1426", "Sang dessus-dessous.", "QUE-0782") != 0) return 1;
		if(insertAchievement("SBQ-1427", "Un remède à tous les maux", "QUE-0782") != 0) return 1;


		if(insertAchievement("QUE-0783", "Les rescapés de Frigost", "CHA-185") != 0) return 1;

		if(insertAchievement("SBQ-1428", "Bricole Girl.", "QUE-0783") != 0) return 1;
		if(insertAchievement("SBQ-1429", "Promenons-nous dans les bois.", "QUE-0783") != 0) return 1;
		if(insertAchievement("SBQ-1430", "Les chasseurs.", "QUE-0783") != 0) return 1;
		if(insertAchievement("SBQ-1431", "Il préfère la mort en mer.", "QUE-0783") != 0) return 1;
		if(insertAchievement("SBQ-1432", "Chauffage à moindre frais.", "QUE-0783") != 0) return 1;
		if(insertAchievement("SBQ-1433", "À la recherche de Dan Lavy.", "QUE-0783") != 0) return 1;
		if(insertAchievement("SBQ-1434", "À qui profite le boufmouth.", "QUE-0783") != 0) return 1;
		if(insertAchievement("SBQ-1435", "Dépôt de ravitaillement.", "QUE-0783") != 0) return 1;
		if(insertAchievement("SBQ-1436", "Un ami qui ne vous veut pas que du bien.", "QUE-0783") != 0) return 1;
		if(insertAchievement("SBQ-1437", "Maya la belle.", "QUE-0783") != 0) return 1;

		if(insertAchievement("QUE-0784", "Agriculture ou alchimie", "CHA-185") != 0) return 1;

		if(insertAchievement("SBQ-1438", "Récolte dans les champs de glace", "QUE-0784") != 0) return 1;
		if(insertAchievement("SBQ-1439", "Récolte dans la forêt des pins perdus", "QUE-0784") != 0) return 1;
		if(insertAchievement("SBQ-1440", "Récolte dans le lac gelé", "QUE-0784") != 0) return 1;
		if(insertAchievement("SBQ-1441", "Récolte dans le berceau d''Alma", "QUE-0784") != 0) return 1;
		if(insertAchievement("SBQ-1442", "Récolte dans les larmes d''Ouronigride", "QUE-0784") != 0) return 1;
		if(insertAchievement("SBQ-1443", "Récolte dans l''hypogée de l''Obsidiantre", "QUE-0784") != 0) return 1;
		if(insertAchievement("SBQ-1444", "Récolte dans la crevasse Perge", "QUE-0784") != 0) return 1;
		if(insertAchievement("SBQ-1445", "Récolte dans la forêt pétrifiée", "QUE-0784") != 0) return 1;
		if(insertAchievement("SBQ-1446", "Récolte dans les crocs de verre", "QUE-0784") != 0) return 1;
		if(insertAchievement("SBQ-1447", "Récolte dans le Mont Torrideau", "QUE-0784") != 0) return 1;

		if(insertAchievement("QUE-0785", "Problèmes et solutions", "CHA-185") != 0) return 1;

		if(insertAchievement("SBQ-1448", "Pauvre Kiki.", "QUE-0785") != 0) return 1;
		if(insertAchievement("SBQ-1449", "Star ski et Dutch.", "QUE-0785") != 0) return 1;
		if(insertAchievement("SBQ-1450", "Groméo et Ginette.", "QUE-0785") != 0) return 1;
		if(insertAchievement("SBQ-1451", "La marche de l''impératrice.", "QUE-0785") != 0) return 1;
		if(insertAchievement("SBQ-1452", "Gène et tique.", "QUE-0785") != 0) return 1;
		if(insertAchievement("SBQ-1453", "Manque de re-peau.", "QUE-0785") != 0) return 1;
		if(insertAchievement("SBQ-1454", "Scierie Bambelle.", "QUE-0785") != 0) return 1;
		if(insertAchievement("SBQ-1455", "Semer ses graines.", "QUE-0785") != 0) return 1;
		if(insertAchievement("SBQ-1456", "Une blague vaseuse?", "QUE-0785") != 0) return 1;
		if(insertAchievement("SBQ-1457", "Un volcan s''éteint.", "QUE-0785") != 0) return 1;

		if(insertAchievement("QUE-0786", "Objets trouvés", "CHA-185") != 0) return 1;

		if(insertAchievement("SBQ-1458", "Souvenir, souvenir.", "QUE-0786") != 0) return 1;
		if(insertAchievement("SBQ-1459", "Bricoleur de génie.", "QUE-0786") != 0) return 1;
		if(insertAchievement("SBQ-1460", "Un gros cube, un p''ti cube.", "QUE-0786") != 0) return 1;
		if(insertAchievement("SBQ-1461", "Bijoux de famille.", "QUE-0786") != 0) return 1;
		if(insertAchievement("SBQ-1462", "Obscurantisme.", "QUE-0786") != 0) return 1;
		if(insertAchievement("SBQ-1463", "Monstre aux plantes.", "QUE-0786") != 0) return 1;
		if(insertAchievement("SBQ-1464", "La transe du crystal.", "QUE-0786") != 0) return 1;
		if(insertAchievement("SBQ-1465", "Art nacre.", "QUE-0786") != 0) return 1;
		if(insertAchievement("SBQ-1466", "Glourmandise", "QUE-0786") != 0) return 1;

		if(insertAchievement("QUE-0787", "L''heure, c''est l''heure", "CHA-185") != 0) return 1;

		if(insertAchievement("SBQ-1467", "Blessure de chasse.", "QUE-0787") != 0) return 1;
		if(insertAchievement("SBQ-1468", "Chasse dangereuse.", "QUE-0787") != 0) return 1;
		if(insertAchievement("SBQ-1469", "Rentrer brocouille.", "QUE-0787") != 0) return 1;
		if(insertAchievement("SBQ-1470", "L''abominable YeCh''Ti.", "QUE-0787") != 0) return 1;
		if(insertAchievement("SBQ-1471", "Bonmonstres de neige.", "QUE-0787") != 0) return 1;
		if(insertAchievement("SBQ-1472", "Le convoi, le sage aussi.", "QUE-0787") != 0) return 1;

		if(insertAchievement("QUE-0788", "Forage à tout va", "CHA-185") != 0) return 1;

		if(insertAchievement("SBQ-1473", "Pêche en eaux gelées.", "QUE-0788") != 0) return 1;
		if(insertAchievement("SBQ-1474", "Il est frais mon pichon.", "QUE-0788") != 0) return 1;

		if(insertAchievement("QUE-0789", "Les carrières de glace", "CHA-185") != 0) return 1;

		if(insertAchievement("SBQ-1475", "Hôtel de glace.", "QUE-0789") != 0) return 1;
		if(insertAchievement("SBQ-1476", "La fonte des glaces.", "QUE-0789") != 0) return 1;
		if(insertAchievement("SBQ-1477", "L''ombre et la glace", "QUE-0789") != 0) return 1;
		if(insertAchievement("SBQ-1478", "Lumière sur l''ombre", "QUE-0789") != 0) return 1;
		if(insertAchievement("SBQ-1479", "Qu''est-ce qu''on a fait des tuyaux?", "QUE-0789") != 0) return 1;
		if(insertAchievement("SBQ-1480", "Lâcher les gaz", "QUE-0789") != 0) return 1;

		if(insertAchievement("QUE-0790", "Ongles incarnés", "CHA-185") != 0) return 1;

		if(insertAchievement("SBQ-1481", "Inferno.", "QUE-0790") != 0) return 1;
		if(insertAchievement("SBQ-1482", "Tous pour un.", "QUE-0790") != 0) return 1;
		if(insertAchievement("SBQ-1483", "Voleur en tout genre.", "QUE-0790") != 0) return 1;
		if(insertAchievement("SBQ-1484", "Le travail c''est la santé.", "QUE-0790") != 0) return 1;



		if(insertAchievement("CHA-186", "Activités frigostiennes", "SUB-048") != 0) return 1;


		if(insertAchievement("QUE-0791", "Intérimaire frigostien (2 quêtes au choix)", "CHA-086") != 0) return 1;

		if(insertAchievement("SBQ-1485", "Michons fleuris (Alchimiste)", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1486", "On se lève tous pour Annette (Paysan)", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1487", "Heureusement il a faim, Duss (Pêcheur)", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1488", "Mmmh, Shab''Al (Chasseur)", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1489", "Mines Anti-personnel (Mineur)", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1490", "Chaudière au charbon (Bûcheron)", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1491", "Le calendrier des récoltes", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1492", "C''est bon pour le moral (Boulanger)", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1493", "Le jeu du Slibou (Sculteur de Bâtons)", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1494", "Gastronomie en Culotte Courte (Poissonnier)", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1495", "Marche ou tombe (Cordonnier)", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1496", "Dessine-moi un bouton (Tailleur)", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1497", "Une famille en or (Bijoutier)", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1498", "Du plomb dans la cervelle (Boucher)", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1499", "Caisse qui dit (Bricoleur)", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1500", "Monsieur n''est pas une tapette (Forgeur de Marteaux)", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1501", "Scie sans soixante si (Forgeur de Haches)", "QUE-0791") != 0) return 1;
		if(insertAchievement("SBQ-1502", "J''aurais voulu être un artisan", "QUE-0791") != 0) return 1;


		if(insertAchievement("QUE-0792", "Chasse gardée", "CHA-086") != 0) return 1;

		if(insertAchievement("SBQ-1503", "Michel Shel enquille ton Bouftonmouth (ou)", "QUE-0792") != 0) return 1;
		if(insertAchievement("SBQ-1504", "Éspèce menacée (ou)", "QUE-0792") != 0) return 1;
		if(insertAchievement("SBQ-1505", "Pied joyeux (ou)", "QUE-0792") != 0) return 1;
		if(insertAchievement("SBQ-1506", "La mort ou va si bien (ou)", "QUE-0792") != 0) return 1;
		if(insertAchievement("SBQ-1507", "Passe ta larme à gauche (ou)", "QUE-0792") != 0) return 1;
		if(insertAchievement("SBQ-1508", "Une mine patibulaire (ou)", "QUE-0792") != 0) return 1;


		if(insertAchievement("QUE-0793", "Tire la chasse", "CHA-086") != 0) return 1;

		if(insertAchievement("SBQ-1509", "Complètement givré (ou)", "QUE-0793") != 0) return 1;
		if(insertAchievement("SBQ-1510", "L''appel de la forêt (ou)", "QUE-0793") != 0) return 1;
		if(insertAchievement("SBQ-1511", "Crocs en jambe (ou)", "QUE-0793") != 0) return 1;
		if(insertAchievement("SBQ-1512", "Ourse molle (ou)", "QUE-0793") != 0) return 1;


		if(insertAchievement("QUE-0794", "Une piqûre de plus", "CHA-086") != 0) return 1;

		if(insertAchievement("SBQ-1513", "Pas de vaccin pour les vilains", "QUE-0794") != 0) return 1;


		if(insertAchievement("QUE-0795", "L''hiver sera rude", "CHA-086") != 0) return 1;

		if(insertAchievement("SBQ-1514", "Faire le tas de pins", "QUE-0795") != 0) return 1;


		if(insertAchievement("QUE-0796", "Tourisme hivernal", "CHA-086") != 0) return 1;

		if(insertAchievement("SBQ-1515", "Vacances sur glace", "QUE-0796") != 0) return 1;


		if(insertAchievement("QUE-0797", "Parent indigne", "CHA-086") != 0) return 1;

		if(insertAchievement("SBQ-1516", "Adoption éphémère", "QUE-0797") != 0) return 1;


		if(insertAchievement("QUE-0798", "Dans les dents", "CHA-086") != 0) return 1;

		if(insertAchievement("SBQ-1517", "Collecte sanglante", "QUE-0798") != 0) return 1;


		if(insertAchievement("QUE-0799", "Porte, monstre, trésor", "CHA-086") != 0) return 1;

		if(insertAchievement("SBQ-1518", "Porte, Royalmouth, trésor", "QUE-0799") != 0) return 1;
		if(insertAchievement("SBQ-1519", "Porte, Mansot Royal, trésor", "QUE-0799") != 0) return 1;
		if(insertAchievement("SBQ-1520", "Porte, Ben le Ripate, trésor", "QUE-0799") != 0) return 1;
		if(insertAchievement("SBQ-1521", "Porte, Obsidiantre, trésor", "QUE-0799") != 0) return 1;
		if(insertAchievement("SBQ-1522", "Porte, Tengu Givrefoux, trésor", "QUE-0799") != 0) return 1;
		if(insertAchievement("SBQ-1523", "Porte, Korriandre, trésor", "QUE-0799") != 0) return 1;
		if(insertAchievement("SBQ-1524", "Porte, Kolosso, trésor", "QUE-0799") != 0) return 1;
		if(insertAchievement("SBQ-1525", "Porte, Glourséleste, trésor", "QUE-0799") != 0) return 1;



		if(insertAchievement("CHA-187", "Des trucs inutiles", "SUB-048") != 0) return 1;


		if(insertAchievement("QUE-0800", "On a tous 5 Apéwicubes en commun (5 apéwicubes)", "CHA-187") != 0) return 1;

		if(insertAchievement("QUE-0801", "Trésor public (1 coffre)", "CHA-187") != 0) return 1;

		if(insertAchievement("QUE-0802", "Tomber dans le panneau (10 panneaux)", "CHA-187") != 0) return 1;

		if(insertAchievement("QUE-0803", "Corruption de Dremoan (5 pourritures)", "CHA-187") != 0) return 1;

		if(insertAchievement("QUE-0804", "Se mettre aux vers (20 vers)", "CHA-187") != 0) return 1;


		if(insertAchievement("CHA-188", "Un songe en hiver", "SUB-048") != 0) return 1;


		if(insertAchievement("QUE-0805", "Mais où qu''ils sont les Frigostiens?", "CHA-188") != 0) return 1;

		if(insertAchievement("SBQ-1526", "Rappel à la vie", "QUE-0805") != 0) return 1;
		if(insertAchievement("SBQ-1527", "Moteur à explosion", "QUE-0805") != 0) return 1;
		if(insertAchievement("SBQ-1528", "La fifille à son papa", "QUE-0805") != 0) return 1;
		if(insertAchievement("SBQ-1529", "Mutinerie chez les Armutins", "QUE-0805") != 0) return 1;
		if(insertAchievement("SBQ-1530", "Au-delà du mur", "QUE-0805") != 0) return 1;
		if(insertAchievement("SBQ-1531", "Crise d''ex-Emma", "QUE-0805") != 0) return 1;


		if(insertAchievement("QUE-0806", "La glace répare, la glace remplace", "CHA-188") != 0) return 1;

		if(insertAchievement("SBQ-1532", "La machine à démonter le temps", "QUE-0806") != 0) return 1;


		if(insertAchievement("QUE-0807", "Noblesse oblige", "CHA-188") != 0) return 1;

		if(insertAchievement("SBQ-1532a", "La tour de guet", "QUE-0807") != 0) return 1;
		if(insertAchievement("SBQ-1533", "Guerre froide", "QUE-0807") != 0) return 1;
		if(insertAchievement("SBQ-1534", "Les desseins de Sylargh", "QUE-0807") != 0) return 1;
		if(insertAchievement("SBQ-1535", "Vous avez demandé la peau lisse?", "QUE-0807") != 0) return 1;
		if(insertAchievement("SBQ-1536", "La dernière carte", "QUE-0807") != 0) return 1;



		if(insertAchievement("CHA-189", "À cause des glaçons", "SUB-048") != 0) return 1;


		if(insertAchievement("QUE-0808", "Carnage de glace", "CHA-189") != 0) return 1;

		if(insertAchievement("SBQ-1537", "Blouson noir", "QUE-0808") != 0) return 1;
		if(insertAchievement("SBQ-1538", "Boîte de conserve", "QUE-0808") != 0) return 1;
		if(insertAchievement("SBQ-1539", "Le cinquième élément", "QUE-0808") != 0) return 1;


		if(insertAchievement("QUE-0809", "Donjons à l''ancienne", "CHA-189") != 0) return 1;

		if(insertAchievement("SBQ-1540", "Porte, Nileza, trésor", "QUE-0809") != 0) return 1;
		if(insertAchievement("SBQ-1541", "Porte, Sylargh, trésor", "QUE-0809") != 0) return 1;
		if(insertAchievement("SBQ-1542", "Porte, Klime, trésor", "QUE-0809") != 0) return 1;
		if(insertAchievement("SBQ-1543", "Porte, Missiz Frizz, trésor", "QUE-0809") != 0) return 1;
		if(insertAchievement("SBQ-1544", "Porte, Comte Harebourg, trésor", "QUE-0809") != 0) return 1;

		if(insertAchievement("QUE-0810", "Regarde ce que j''ai trouvé", "CHA-189") != 0) return 1;

		if(insertAchievement("SBQ-1545", "Passer du Cocalane", "QUE-0810") != 0) return 1;
		if(insertAchievement("SBQ-1546", "Le jour de la serviette", "QUE-0810") != 0) return 1;
		if(insertAchievement("SBQ-1547", "Un string de caractère", "QUE-0810") != 0) return 1;
		if(insertAchievement("SBQ-1548", "Voilà où ça nous mène", "QUE-0810") != 0) return 1;
		if(insertAchievement("SBQ-1549", "Y''a pas écrit la poste", "QUE-0810") != 0) return 1;



		if(insertAchievement("CHA-190", "Des trucs sans interêt", "SUB-048") != 0) return 1;


		if(insertAchievement("QUE-0811", "Expérimentations hasardeuses (5 potions)", "CHA-190") != 0) return 1;

		if(insertAchievement("QUE-0812", "Drôle d''assemblage (1 prototype de KC RUR)", "CHA-190") != 0) return 1;

		if(insertAchievement("QUE-0813", "Faire la peau (5 cuirs tannés)", "CHA-190") != 0) return 1;

		if(insertAchievement("QUE-0814", "Collection martiale (5 armes gelées)", "CHA-190") != 0) return 1;

		if(insertAchievement("QUE-0815", "Kling Klong (5 billes magiques)", "CHA-190") != 0) return 1;



		if(insertAchievement("CHA-191", "Autres", "SUB-048") != 0) return 1;


		if(insertAchievement("QUE-0816", "C''est assez", "CHA-191") != 0) return 1;

		if(insertAchievement("SBQ-1550", "Ponctions létales", "QUE-0816") != 0) return 1;
		if(insertAchievement("SBQ-1551", "Grand corps malade", "QUE-0816") != 0) return 1;
		if(insertAchievement("SBQ-1552", "Qui dit baume", "QUE-0816") != 0) return 1;

		if(insertAchievement("QUE-0817", "Chahuteur clandestin", "CHA-191") != 0) return 1;

		if(insertAchievement("QUE-0818", "Ondine ensemble ce soir", "CHA-191") != 0) return 1;

		if(insertAchievement("QUE-0819", "Slip ou caleçon?", "CHA-191") != 0) return 1;




		if(insertAchievement("SUB-049", "Île de Moon", "SUC-05") != 0) return 1;



		if(insertAchievement("CHA-192", "T''as le look koko", "SUB-049") != 0) return 1;


		if(insertAchievement("QUE-0820", "Koko Boy", "CHA-192") != 0) return 1;

		if(insertAchievement("SBQ-1553", "Partir un jour sans retour", "QUE-0820") != 0) return 1;
		if(insertAchievement("SBQ-1554", "Un parfum de vacances", "QUE-0820") != 0) return 1;
		if(insertAchievement("SBQ-1555", "Un indigeste chez les indigènes", "QUE-0820") != 0) return 1;
		if(insertAchievement("SBQ-1556", "Squelettes et amulettes", "QUE-0820") != 0) return 1;
		if(insertAchievement("SBQ-1557", "Rendez-vous avec la lune", "QUE-0820") != 0) return 1;


		if(insertAchievement("QUE-0821", "Monnaie de singe", "CHA-192") != 0) return 1;

		if(insertAchievement("SBQ-1558", "Le radeau ivre", "QUE-0821") != 0) return 1;
		if(insertAchievement("SBQ-1559", "Sur les traces des Moonies", "QUE-0821") != 0) return 1;
		if(insertAchievement("SBQ-1560", "Le combat des chefs", "QUE-0821") != 0) return 1;
		if(insertAchievement("SBQ-1561", "Bas les masques", "QUE-0821") != 0) return 1;
		if(insertAchievement("SBQ-1562", "Serrons-nous la main", "QUE-0821") != 0) return 1;




		if(insertAchievement("SUB-050", "Île d''Otomaï", "SUC-05") != 0) return 1;



		if(insertAchievement("CHA-193", "Y''a qu''Otomaï qui m''aille", "SUB-050") != 0) return 1;


		if(insertAchievement("QUE-0822", "La grande Kradoc", "CHA-193") != 0) return 1;

		if(insertAchievement("SBQ-1563", "Le nouveau monde", "QUE-0822") != 0) return 1;
		if(insertAchievement("SBQ-1564", "L''île des naufragés", "QUE-0822") != 0) return 1;


		if(insertAchievement("QUE-0823", "Haute voltige", "CHA-193") != 0) return 1;

		if(insertAchievement("SBQ-1565", "Scaéroplane à très grande vitesse", "QUE-0823") != 0) return 1;
		if(insertAchievement("SBQ-1566", "Un autre moyen de transport", "QUE-0823") != 0) return 1;


		if(insertAchievement("QUE-0824", "Service de dépannage", "CHA-193") != 0) return 1;


		if(insertAchievement("SBQ-1567", "Paulette Pain-bèche la boulangère", "QUE-0824") != 0) return 1;
		if(insertAchievement("SBQ-1568", "Polka Merer a besoin de vous", "QUE-0824") != 0) return 1;
		if(insertAchievement("SBQ-1569", "La potion Bulbique", "QUE-0824") != 0) return 1;
		if(insertAchievement("SBQ-1570", "Le fils caché", "QUE-0824") != 0) return 1;
		if(insertAchievement("SBQ-1571", "La femme perdue", "QUE-0824") != 0) return 1;
		if(insertAchievement("SBQ-1572", "Les Chasses de Crocodaille Dandi", "QUE-0824") != 0) return 1;


		if(insertAchievement("QUE-0825", "Sacrée Tourbière", "CHA-193") != 0) return 1;

		if(insertAchievement("SBQ-1573", "Le Gardien du Pont de la Mort", "QUE-0825") != 0) return 1;
		if(insertAchievement("SBQ-1574", "La vengeance du Kito", "QUE-0825") != 0) return 1;
		if(insertAchievement("SBQ-1575", "La vengeance de Peggy la Porkass", "QUE-0825") != 0) return 1;
		if(insertAchievement("SBQ-1576", "Le Chevalier Noir et Rose", "QUE-0825") != 0) return 1;





		if(insertAchievement("SUB-051", "Île des Wabbits", "SUC-05") != 0) return 1;



		if(insertAchievement("CHA-194", "Bibelots de Wabbit", "SUB-051") != 0) return 1;


		if(insertAchievement("QUE-0826", "Rusé comme une Lenalde", "CHA-194") != 0) return 1;

		if(insertAchievement("SBQ-1577", "Sauvegarder l''espèce", "QUE-0826") != 0) return 1;
		if(insertAchievement("SBQ-1578", "Faites l''amour, pas la guerre", "QUE-0826") != 0) return 1;
		if(insertAchievement("SBQ-1579", "Ça sent la cawotte", "QUE-0826") != 0) return 1;
		if(insertAchievement("SBQ-1580", "Il y a un os, de Wabbit", "QUE-0826") != 0) return 1;
		if(insertAchievement("SBQ-1581", "Art gastronomique", "QUE-0826") != 0) return 1;
		if(insertAchievement("SBQ-1582", "Expédition culinaire", "QUE-0826") != 0) return 1;
		if(insertAchievement("SBQ-1583", "Voyage au centre du Wabbit", "QUE-0826") != 0) return 1;
		if(insertAchievement("SBQ-1584", "Des pwinces pas très charmants", "QUE-0826") != 0) return 1;


		if(insertAchievement("QUE-0827", "Lancer de Wabbit", "CHA-194") != 0) return 1;

		if(insertAchievement("SBQ-1585", "Timassacre entre wabbits", "QUE-0827") != 0) return 1;
		if(insertAchievement("SBQ-1586", "Comme d''wabbitude", "QUE-0827") != 0) return 1;
		if(insertAchievement("SBQ-1587", "Vade Retro Wabbitas", "QUE-0827") != 0) return 1;
		if(insertAchievement("SBQ-1588", "Chasse aux wabbits", "QUE-0827") != 0) return 1;


		if(insertAchievement("QUE-0828", "Un Wa de pacotille", "CHA-194") != 0) return 1;

		if(insertAchievement("SBQ-1589", "Jamais deux sans trois", "QUE-0828") != 0) return 1;
		if(insertAchievement("SBQ-1590", "Le château du Wa", "QUE-0828") != 0) return 1;
		if(insertAchievement("SBQ-1591", "L''oeuf ou la cawotte?", "QUE-0828") != 0) return 1;


		if(insertAchievement("QUE-0829", "Poil de Cawotte", "CHA-194") != 0) return 1;

		if(insertAchievement("SBQ-1592", "Se faire passer pour le Wa Wabbit", "QUE-0829") != 0) return 1;


		if(insertAchievement("QUE-0830", "Partie prise", "CHA-194") != 0) return 1;

		if(insertAchievement("SBQ-1593", "Intrusion chez les wabbits", "QUE-0830") != 0) return 1;
		if(insertAchievement("SBQ-1594", "Caltes stlatégiques", "QUE-0830") != 0) return 1;
		if(insertAchievement("SBQ-1595", "Le jeu de Lenald", "QUE-0830") != 0) return 1;


		if(insertAchievement("QUE-0831", "Wabbit en feu", "CHA-194") != 0) return 1;

		if(insertAchievement("SBQ-1596", "Un peu de wab.", "QUE-0831") != 0) return 1;
		if(insertAchievement("SBQ-1597", "Ça rend aimable.", "QUE-0831") != 0) return 1;
		if(insertAchievement("SBQ-1598", "Les pwinces déchus.", "QUE-0831") != 0) return 1;
		if(insertAchievement("SBQ-1599", "La chasse de Lily", "QUE-0831") != 0) return 1;



		if(insertAchievement("SUB-052", "Incarnam", "SUC-05") != 0) return 1;



		if(insertAchievement("CHA-195", "Des débuts exemplaires", "SUB-052") != 0) return 1;


		if(insertAchievement("QUE-0832", "Poussé par le vent", "CHA-195") != 0) return 1;

		if(insertAchievement("SBQ-1600", "Transport peu commun", "QUE-0832") != 0) return 1;
		if(insertAchievement("SBQ-1601", "Des vestiges de légende", "QUE-0832") != 0) return 1;
		if(insertAchievement("SBQ-1602", "Vu du ciel", "QUE-0832") != 0) return 1;


		if(insertAchievement("QUE-0833", "Service dans la milice", "CHA-195") != 0) return 1;

		if(insertAchievement("SBQ-1603", "Mise à l''épreuve", "QUE-0833") != 0) return 1;
		if(insertAchievement("SBQ-1604", "Champs de bataille", "QUE-0833") != 0) return 1;
		if(insertAchievement("SBQ-1605", "Coups d''épée dans l''eau", "QUE-0833") != 0) return 1;
		if(insertAchievement("SBQ-1606", "Décime-moi des bouftous", "QUE-0833") != 0) return 1;
		if(insertAchievement("SBQ-1607", "Chasse aux Chapardams", "QUE-0833") != 0) return 1;
		if(insertAchievement("SBQ-1608", "Leçon d''humilité", "QUE-0833") != 0) return 1;
		if(insertAchievement("SBQ-1609", "Des chafers qui marchent", "QUE-0833") != 0) return 1;


		if(insertAchievement("QUE-0834", "C''est le métier qui rentre", "CHA-195") != 0) return 1;

		if(insertAchievement("SBQ-1610", "Produits naturels", "QUE-0834") != 0) return 1;
		if(insertAchievement("SBQ-1611", "La hache et la pioche", "QUE-0834") != 0) return 1;
		if(insertAchievement("SBQ-1612", "Boune un jour, boune toujours", "QUE-0834") != 0) return 1;
		if(insertAchievement("SBQ-1613", "Le choix des armes", "QUE-0834") != 0) return 1;

		if(insertAchievement("QUE-0835", "Ramdam sur Incarnam", "CHA-195") != 0) return 1;

		if(insertAchievement("SBQ-1614", "La galette secrète", "QUE-0835") != 0) return 1;
		if(insertAchievement("SBQ-1615", "Mort au rat!", "QUE-0835") != 0) return 1;
		if(insertAchievement("SBQ-1616", "Cryptologie", "QUE-0835") != 0) return 1;
		if(insertAchievement("SBQ-1617", "Un peu de pigment", "QUE-0835") != 0) return 1;



		if(insertAchievement("SUB-053", "Montagne des Koalaks", "SUC-05") != 0) return 1;


		if(insertAchievement("CHA-196", "Convoyeur de fond en comble", "SUB-053") != 0) return 1;

		if(insertAchievement("QUE-0836", "Course polaire", "CHA-196") != 0) return 1;
		if(insertAchievement("QUE-0837", "Épicerie fine", "CHA-196") != 0) return 1;
		if(insertAchievement("QUE-0838", "Charger la mule", "CHA-196") != 0) return 1;



		if(insertAchievement("SUB-054", "Nimotopia", "SUC-05") != 0) return 1;


		if(insertAchievement("CHA-197", "La chasse aux chasseurs", "SUB-054") != 0) return 1;

		if(insertAchievement("QUE-0839", "À plus dans l''muldobus", "CHA-197") != 0) return 1;
		if(insertAchievement("QUE-0840", "Frais de porc inclus", "CHA-197") != 0) return 1;
		if(insertAchievement("QUE-0841", "Il a fui, il a tout compris", "CHA-197") != 0) return 1;
		if(insertAchievement("QUE-0842", "La valse des manuels", "CHA-197") != 0) return 1;
		if(insertAchievement("QUE-0843", "Nos amies les bêtes", "CHA-197") != 0) return 1;
		if(insertAchievement("QUE-0844", "Shyriiwook", "CHA-197") != 0) return 1;
		if(insertAchievement("QUE-0845", "À armes égales", "CHA-197") != 0) return 1;



		if(insertAchievement("SUB-055", "Port de Madrestam", "SUC-05") != 0) return 1;


		if(insertAchievement("CHA-198", "Léchage de bottes", "SUB-055") != 0) return 1;

		if(insertAchievement("QUE-0846", "Les Dents de la Mère Verumacha", "CHA-198") != 0) return 1;
		if(insertAchievement("QUE-0847", "La potion de lèche-bottes", "CHA-198") != 0) return 1;
		if(insertAchievement("QUE-0848", "La belle ermite", "CHA-198") != 0) return 1;



		if(insertAchievement("SUB-056", "Province d''Amakna", "SUC-05") != 0) return 1;


		if(insertAchievement("CHA-199", "Destination Aventure", "SUB-056") != 0) return 1;

		if(insertAchievement("QUE-0849", "Fantômes contre fantômes.", "CHA-199") != 0) return 1;
		if(insertAchievement("QUE-0850", "L''ascension.", "CHA-199") != 0) return 1;
		if(insertAchievement("QUE-0851", "T''as les boules.", "CHA-199") != 0) return 1;



		if(insertAchievement("SUB-057", "Saharach", "SUC-05") != 0) return 1;



		if(insertAchievement("CHA-200", "Le marchand de sable est passé", "SUB-057") != 0) return 1;


		if(insertAchievement("QUE-0852", "Le plein d''Épice", "CHA-200") != 0) return 1;

		if(insertAchievement("SBQ-1618", "L''allégorie de la taverne", "QUE-0852") != 0) return 1;
		if(insertAchievement("SBQ-1619", "Filouterie épicée", "QUE-0852") != 0) return 1;
		if(insertAchievement("SBQ-1620", "Ali Babaorom et les quatre autres voleurs", "QUE-0852") != 0) return 1;
		if(insertAchievement("SBQ-1621", "Faune pimentée", "QUE-0852") != 0) return 1;
		if(insertAchievement("SBQ-1622", "Chargement déserté", "QUE-0852") != 0) return 1;
		if(insertAchievement("SBQ-1623", "Retrouver un fémur dans une botte d''ossements", "QUE-0852") != 0) return 1;
		if(insertAchievement("SBQ-1624", "Demande anonyme", "QUE-0852") != 0) return 1;
		if(insertAchievement("SBQ-1625", "L''eau douce ou l''eau dure", "QUE-0852") != 0) return 1;
		if(insertAchievement("SBQ-1626", "Désert dde revanche", "QUE-0852") != 0) return 1;
		if(insertAchievement("SBQ-1627", "Les bizarreries du Phare Ouest", "QUE-0852") != 0) return 1;
		if(insertAchievement("SBQ-1628", "Sans chair et en os", "QUE-0852") != 0) return 1;


		if(insertAchievement("QUE-0853", "Privé de désert", "CHA-200") != 0) return 1;

		if(insertAchievement("SBQ-1629", "L''Étoile de la mer", "QUE-0853") != 0) return 1;
		if(insertAchievement("SBQ-1630", "Le fou rit et rôde", "QUE-0853") != 0) return 1;
		if(insertAchievement("SBQ-1631", "La barrière des langues", "QUE-0853") != 0) return 1;
		if(insertAchievement("SBQ-1632", "Donner l''amour, pas le fouet", "QUE-0853") != 0) return 1;
		if(insertAchievement("SBQ-1633", "Taper ou parler, il faut choisir", "QUE-0853") != 0) return 1;
		if(insertAchievement("SBQ-1634", "Le Quiki de tous les Quikis", "QUE-0853") != 0) return 1;
		if(insertAchievement("SBQ-1635", "Une mine de déterré", "QUE-0853") != 0) return 1;
		if(insertAchievement("SBQ-1636", "Terres mortes", "QUE-0853") != 0) return 1;


		if(insertAchievement("QUE-0854", "Au clair de la dune", "CHA-200") != 0) return 1;

		if(insertAchievement("SBQ-1637", "L''Épice rit", "QUE-0854") != 0) return 1;
		if(insertAchievement("SBQ-1638", "Le roi scorpion", "QUE-0854") != 0) return 1;
		if(insertAchievement("SBQ-1639", "Ne pas payer de mine", "QUE-0854") != 0) return 1;
		if(insertAchievement("SBQ-1640", "Le monde entier est un cactus", "QUE-0854") != 0) return 1;


		if(insertAchievement("QUE-0855", "Sous le soleil de Saharach", "CHA-200") != 0) return 1;

		if(insertAchievement("SBQ-1641", "Perché là-haut", "QUE-0855") != 0) return 1;
		if(insertAchievement("SBQ-1642", "Saharach, territoire verdoyant?", "QUE-0855") != 0) return 1;
		if(insertAchievement("SBQ-1643", "La cité des truites", "QUE-0855") != 0) return 1;
		if(insertAchievement("SBQ-1644", "Un problème de serre-ure", "QUE-0855") != 0) return 1;
		if(insertAchievement("SBQ-1645", "L''archéologie, c''est facile", "QUE-0855") != 0) return 1;
		if(insertAchievement("SBQ-1646", "Momie molette", "QUE-0855") != 0) return 1;


		if(insertAchievement("QUE-0856", "Que cherche la Corporation?", "CHA-200") != 0) return 1;

		if(insertAchievement("SBQ-1647", "Un ver, ça va, trop de vers, bonjour les dégâts", "QUE-0856") != 0) return 1;
		if(insertAchievement("SBQ-1648", "Le mystère des vers", "QUE-0856") != 0) return 1;
		if(insertAchievement("SBQ-1649", "Momies en folie", "QUE-0856") != 0) return 1;
		if(insertAchievement("SBQ-1650", "Le secret de la pyramide", "QUE-0856") != 0) return 1;



		if(insertAchievement("SUB-058", "Sidimote", "SUC-05") != 0) return 1;


		if(insertAchievement("CHA-201", "Sidimotivé", "SUB-058") != 0) return 1;


		if(insertAchievement("QUE-0857", "Les landes mortes", "CHA-201") != 0) return 1;

		if(insertAchievement("SBQ-1651", "Le mort dort", "QUE-0857") != 0) return 1;
		if(insertAchievement("SBQ-1652", "Faire le mort", "QUE-0857") != 0) return 1;
		if(insertAchievement("SBQ-1653", "Trou de mémoire", "QUE-0857") != 0) return 1;
		if(insertAchievement("SBQ-1654", "Les morts vivants", "QUE-0857") != 0) return 1;


		if(insertAchievement("QUE-0858", "Hurlements de rire", "CHA-201") != 0) return 1;

		if(insertAchievement("SBQ-1655", "Retour aux sources", "QUE-0858") != 0) return 1;
		if(insertAchievement("SBQ-1656", "Division par deux", "QUE-0858") != 0) return 1;
		if(insertAchievement("SBQ-1657", "Cours Forestière", "QUE-0858") != 0) return 1;
		if(insertAchievement("SBQ-1658", "L''air mythe", "QUE-0858") != 0) return 1;
		if(insertAchievement("SBQ-1659", "La grande parade", "QUE-0858") != 0) return 1;
		if(insertAchievement("SBQ-1660", "Le casse-bonbon", "QUE-0858") != 0) return 1;
		if(insertAchievement("SBQ-1661", "La bête intérieure", "QUE-0858") != 0) return 1;
		if(insertAchievement("SBQ-1662", "Allumer le feu", "QUE-0858") != 0) return 1;


		if(insertAchievement("QUE-0859", "Le double effet Gisgoul", "CHA-201") != 0) return 1;

		if(insertAchievement("SBQ-1663", "L''entrée des artistes", "QUE-0859") != 0) return 1;
		if(insertAchievement("SBQ-1664", "Un salaire germinable", "QUE-0859") != 0) return 1;
		if(insertAchievement("SBQ-1665", "Au pied du mur", "QUE-0859") != 0) return 1;
		if(insertAchievement("SBQ-1666", "Rituel oblige", "QUE-0859") != 0) return 1;


		if(insertAchievement("QUE-0860", "Les spores, c''est la santé", "CHA-201") != 0) return 1;

		if(insertAchievement("SBQ-1667", "Champallucination", "QUE-0860") != 0) return 1;
		if(insertAchievement("SBQ-1668", "Le baptême du feu", "QUE-0860") != 0) return 1;
		if(insertAchievement("SBQ-1669", "Passe le fungue autour de toi", "QUE-0860") != 0) return 1;
		if(insertAchievement("SBQ-1670", "Appui sur le champignon", "QUE-0860") != 0) return 1;
		if(insertAchievement("SBQ-1671", "La prolifération a crû", "QUE-0860") != 0) return 1;


		if(insertAchievement("QUE-0861", "Vampyre, vous avez dit Vampyre?", "CHA-201") != 0) return 1;

		if(insertAchievement("SBQ-1672", "Les goules à zéro", "QUE-0861") != 0) return 1;
		if(insertAchievement("SBQ-1673", "Le trou du culte", "QUE-0861") != 0) return 1;
		if(insertAchievement("SBQ-1674", "Entretien avec une Vampyre", "QUE-0861") != 0) return 1;




		if(insertAchievement("SUB-059", "Sufokia", "SUC-05") != 0) return 1;



		if(insertAchievement("CHA-202", "Abysses", "SUB-059") != 0) return 1;


		if(insertAchievement("QUE-0862", "Test d''étanchéité", "CHA-202") != 0) return 1;

		if(insertAchievement("SBQ-1675", "L''ivresse des profondeurs", "QUE-0862") != 0) return 1;
		if(insertAchievement("SBQ-1676", "Les Merccemers sont bien outillés", "QUE-0862") != 0) return 1;
		if(insertAchievement("SBQ-1677", "Pêche aux krabouilleurs", "QUE-0862") != 0) return 1;
		if(insertAchievement("SBQ-1678", "À bas Kralab Rah", "QUE-0862") != 0) return 1;
		if(insertAchievement("SBQ-1679", "KO pour Bosko Tho", "QUE-0862") != 0) return 1;
		if(insertAchievement("SBQ-1680", "Relevez les niveaux", "QUE-0862") != 0) return 1;
		if(insertAchievement("SBQ-1681", "Prise de notes", "QUE-0862") != 0) return 1;


		if(insertAchievement("QUE-0863", "Plouf!", "CHA-202") != 0) return 1;

		if(insertAchievement("SBQ-1682", "La pêche aux infos", "QUE-0863") != 0) return 1;
		if(insertAchievement("SBQ-1683", "Le héros de Sufokia", "QUE-0863") != 0) return 1;


		if(insertAchievement("QUE-0864", "La mer en héritage", "CHA-202") != 0) return 1;

		if(insertAchievement("SBQ-1684", "Il y a de l''électricité dans l''eau", "QUE-0864") != 0) return 1;
		if(insertAchievement("SBQ-1685", "Topo le petit robot", "QUE-0864") != 0) return 1;
		if(insertAchievement("SBQ-1686", "Piège de crystal", "QUE-0864") != 0) return 1;
		if(insertAchievement("SBQ-1687", "Son nom est personne", "QUE-0864") != 0) return 1;
		if(insertAchievement("SBQ-1688", "La clef de l''énigme", "QUE-0864") != 0) return 1;
		if(insertAchievement("SBQ-1689", "Une porte vers le passé", "QUE-0864") != 0) return 1;


		if(insertAchievement("QUE-0865", "La guerre des profondeurs", "CHA-202") != 0) return 1;

		if(insertAchievement("SBQ-1690", "Reine de beauté", "QUE-0865") != 0) return 1;
		if(insertAchievement("SBQ-1691", "Rançon nage", "QUE-0865") != 0) return 1;
		if(insertAchievement("SBQ-1692", "Stratégie en Trithon Réel", "QUE-0865") != 0) return 1;
		if(insertAchievement("SBQ-1693", "Sur fond de crise", "QUE-0865") != 0) return 1;
		if(insertAchievement("SBQ-1694", "Risquer un oeil", "QUE-0865") != 0) return 1;
		if(insertAchievement("SBQ-1695", "La gueule de l''enfer", "QUE-0865") != 0) return 1;


		if(insertAchievement("QUE-0866", "L''appel de Koutoulou", "CHA-202") != 0) return 1;


		if(insertAchievement("SBQ-1696", "Celle qui glougloutait dans les ténèbres", "QUE-0866") != 0) return 1;
		if(insertAchievement("SBQ-1697", "L''affaire Pollie Perkine", "QUE-0866") != 0) return 1;
		if(insertAchievement("SBQ-1698", "Trop Pollie pour être honnête", "QUE-0866") != 0) return 1;
		if(insertAchievement("SBQ-1699", "Quand les astres seront propices", "QUE-0866") != 0) return 1;
		if(insertAchievement("SBQ-1700", "Il suffira d''un signe", "QUE-0866") != 0) return 1;
		if(insertAchievement("SBQ-1701", "De mal en impie", "QUE-0866") != 0) return 1;


		if(insertAchievement("QUE-0867", "Vous ne descendrez pas plus bas", "CHA-202") != 0) return 1;

		if(insertAchievement("SBQ-1702", "Le vieux gob et la mer", "QUE-0867") != 0) return 1;
		if(insertAchievement("SBQ-1703", "Demain, j''arête", "QUE-0867") != 0) return 1;
		if(insertAchievement("SBQ-1704", "L''effet Paula Rice", "QUE-0867") != 0) return 1;
		if(insertAchievement("SBQ-1705", "Fhtagn!", "QUE-0867") != 0) return 1;


		if(insertAchievement("QUE-0868", "Silence on coule", "CHA-202") != 0) return 1;

		if(insertAchievement("SBQ-1706", "Les sept Mercemers", "QUE-0868") != 0) return 1;
		if(insertAchievement("SBQ-1707", "Nos chairs voisines", "QUE-0868") != 0) return 1;
		if(insertAchievement("SBQ-1708", "Concurrence déloyale", "QUE-0868") != 0) return 1;
		if(insertAchievement("SBQ-1709", "Qui a la plus grosse?", "QUE-0868") != 0) return 1;
		if(insertAchievement("SBQ-1710", "Droit de cuissage", "QUE-0868") != 0) return 1;
		if(insertAchievement("SBQ-1711", "La musique de Rykke Zane", "QUE-0868") != 0) return 1;
		if(insertAchievement("SBQ-1712", "Mémoires d''un amnésique", "QUE-0868") != 0) return 1;
		if(insertAchievement("SBQ-1713", "L''odeur devant le seuil", "QUE-0868") != 0) return 1;
		if(insertAchievement("SBQ-1714", "Aux grands mots les grands remèdes", "QUE-0868") != 0) return 1;



		if(insertAchievement("CHA-203", "Autres", "SUB-059") != 0) return 1;



		if(insertAchievement("QUE-0869", "Le bon air de la mer d''Asse", "CHA-203") != 0) return 1;

		if(insertAchievement("SBQ-1715", "Investigation embarquée", "QUE-0869") != 0) return 1;
		if(insertAchievement("SBQ-1716", "Pattes aux oeufs frais", "QUE-0869") != 0) return 1;
		if(insertAchievement("SBQ-1717", "Collier de perles en vinaigrette", "QUE-0869") != 0) return 1;
		if(insertAchievement("SBQ-1718", "Promenade sur les quais", "QUE-0869") != 0) return 1;
		if(insertAchievement("SBQ-1719", "Des étoiles dans l''estomac", "QUE-0869") != 0) return 1;


		if(insertAchievement("QUE-0870", "Sufokons ensemble", "CHA-203") != 0) return 1;

		if(insertAchievement("SBQ-1720", "Vol au-dessus d''un coucou", "QUE-0870") != 0) return 1;
		if(insertAchievement("SBQ-1721", "Voleurs en série", "QUE-0870") != 0) return 1;
		if(insertAchievement("SBQ-1722", "Moins on en a et plue on l''étale", "QUE-0870") != 0) return 1;
		if(insertAchievement("SBQ-1723", "Distribution de pains zizanesques", "QUE-0870") != 0) return 1;
		if(insertAchievement("SBQ-1724", "Comment se mettre au jus", "QUE-0870") != 0) return 1;
		if(insertAchievement("SBQ-1725", "C''est du Costaud", "QUE-0870") != 0) return 1;


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


		if(insertAchievement("SUB-60", "Général", "SUC-06") != 0) return 1;




		if(insertAchievement("CHA-204", "Ma petite entreprise", "SUB-60") != 0) return 1;



		if(insertAchievement("QUE-0871", "Désolé mais je t''avais en double", "CHA-204") != 0) return 1;

		if(insertAchievement("SBQ-1726", "Briser un Chacha", "QUE-0871") != 0) return 1;


		if(insertAchievement("CHA-205", "Concastagne", "SUB-60") != 0) return 1;

		if(insertAchievement("QUE-0872", "Obtenir 100 runes", "CHA-205") != 0) return 1;


		if(insertAchievement("CHA-206", "Et si je cassais des trucs?", "SUB-60") != 0) return 1;

		if(insertAchievement("QUE-0872a", "Obtenir 1000 runes", "CHA-206") != 0) return 1;


		if(insertAchievement("QUE-0873", "\"Je m''appelle casse partout\"", "CHA-204") != 0) return 1;

		if(insertAchievement("SBQ-1727", "Obtenir 10 000 runes", "QUE-0873") != 0) return 1;


		if(insertAchievement("QUE-0874", "J''apporte la farine et toi le sel", "CHA-204") != 0) return 1;

		if(insertAchievement("SBQ-1728", "Un craft en coopératif", "QUE-0874") != 0) return 1;


		if(insertAchievement("CHA-207", "Je l''ai fait moi-même", "SUB-60") != 0) return 1;

		if(insertAchievement("QUE-0875", "1 craft", "CHA-207") != 0) return 1;


		if(insertAchievement("CHA-208", "Travail à la chaîne", "SUB-60") != 0) return 1;

		if(insertAchievement("QUE-0876", "100 crafts", "CHA-208") != 0) return 1;


		if(insertAchievement("CHA-209", "L''atelier", "SUB-60") != 0) return 1;

		if(insertAchievement("QUE-0877", "1000 crafts", "CHA-209") != 0) return 1;


		if(insertAchievement("QUE-0878", "La manufacture", "CHA-204") != 0) return 1;

		if(insertAchievement("SBQ-1729", "10 000 crafts", "QUE-0878") != 0) return 1;


		if(insertAchievement("CHA-210", "Apprenti", "SUB-60") != 0) return 1;

		if(insertAchievement("QUE-0879", "1 métier niveau 10", "CHA-210") != 0) return 1;


		if(insertAchievement("CHA-211", "Travailleur", "SUB-60") != 0) return 1;

		if(insertAchievement("QUE-0880", "1 métier niveau 100", "CHA-211") != 0) return 1;


		if(insertAchievement("CHA-212", "Compagnon", "SUB-60") != 0) return 1;

		if(insertAchievement("QUE-0881", "1 métier niveau 200", "CHA-212") != 0) return 1;


		if(insertAchievement("CHA-213", "Main d''oeuvre qualifiée", "SUB-60") != 0) return 1;

		if(insertAchievement("QUE-0882", "2 métiers niveau 200", "CHA-213") != 0) return 1;


		if(insertAchievement("QUE-0883", "Huile de coude", "CHA-204") != 0) return 1;

		if(insertAchievement("SBQ-1730", "3 métiers niveau 200", "QUE-0883") != 0) return 1;



		
		
		
		
		
		
		
		
		
		
		
		
		return 0;
	}

	/**
	 * Inserts an achievement in the database
	 * @param id the achievement id
	 * @param name the achivement name
	 * @param parent the achievement parent
	 * @return
	 */
	private static int insertAchievement(String id, String name, String parent) {
		try {
			Connection c = database.getConnection();
			Statement stmt = c.createStatement();

			ResultSet set = stmt.executeQuery("SELECT * FROM Achievement WHERE id LIKE '" + id + "'");

			if(!set.next()){
				String sql = "INSERT INTO Achievement(id, name, parent) VALUES ("
						+ "'" + id + "', "
						+ "'" + name + "', ";

				if(parent != null)
					sql += "'" + parent + "')";
				else
					sql += "null)";

				insert(sql);

				rows++;
				
				stmt.close();
			}else{
				stmt.close();
				
				//System.out.println("Primary key '" + id + "' is already used in ACHIEVEMENT table");
				throw new IllegalArgumentException("Primary key '" + id + "' is already used in ACHIEVEMENT table");
			}

			return 0;
		} catch(Exception e) {
			e.printStackTrace();
		}

		return 1;
	}

	private static int insertPlayer(int id, String name) {
		try {
			Connection c = database.getConnection();
			Statement stmt = c.createStatement();

			ResultSet set = stmt.executeQuery("SELECT * FROM Player WHERE id = " + id);

			if(!set.next()){
				String sql = "INSERT INTO Player VALUES ("
						+ id + ", "
						+ "'" + name + "')";

				insert(sql);

				rows++;
			}else{
				stmt.close();
				
				//System.out.println("Primary key '" + id + "' is already used in PLAYER table");
				throw new IllegalArgumentException("Primary key '" + id + "' is already used in PLAYER table");
			}

			stmt.close();

			return 0;
		} catch(Exception e) {
			e.printStackTrace();
		}

		return 1;
	}

	/**
	 * Inserts one row in the database
	 * @param sql the sql query
	 * @return 0 if success, 1 otherwise
	 */
	private static int insert(String sql) {
		try {
			Connection c = database.getConnection();
			Statement stmt = c.createStatement();

			stmt.executeUpdate(sql);
			stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
			return 1;
		}

		return 0;
	}

	public Map<String, Boolean> setAchieved(String currentId, String parentId, Map<Integer, Integer> checks) {
		Map<String ,Boolean> finished = null;
		
		try {
			Connection c = database.getConnection();
			Statement stmt = c.createStatement();

			int nbInserts = 0;
			finished = new LinkedHashMap<String, Boolean>();

			for(Map.Entry<Integer, Integer> check : checks.entrySet()){
				stmt = c.createStatement();

				if(check.getValue() == 1){
					stmt.executeUpdate("INSERT OR IGNORE INTO Achieved VALUES (" + check.getKey() + ", '" + currentId + "')");
					nbInserts++;
				}else if(check.getValue() == 0){
					stmt.executeUpdate("DELETE FROM Achieved WHERE player = " + check.getKey() + " AND achievement LIKE '" + currentId + "'");
				}

				stmt.close();
			}

			stmt = c.createStatement();
			if(nbInserts == checks.size()){
				stmt.executeUpdate("UPDATE Achievement SET finished = 1 WHERE id LIKE '" + currentId + "'");
				finished.put(currentId, true);
			}else{
				stmt.executeUpdate("UPDATE Achievement SET finished = 0 WHERE id LIKE '" + currentId + "'");
				finished.put(currentId, false);
			}
			stmt.close();

			finishChildren(nbInserts == checks.size(), currentId, checks, finished);
			finishParent(parentId, checks, finished);

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return finished;
	}

	private void finishParent(String parentId, Map<Integer, Integer> checks, Map<String, Boolean> finished) {
		if(!parentId.contains("SUC-")){
			try {
				Connection c = database.getConnection();
				Statement stmt = c.createStatement();

				ResultSet set;

				stmt = c.createStatement();
				set = stmt.executeQuery("SELECT COUNT(*) FROM Achievement WHERE parent LIKE '" + parentId + "' AND finished = 0");
				set.next();
				int count = set.getInt(1);
				stmt.close();
				
				if(count == 0){
					finished.put(parentId, true);
					
					stmt.executeUpdate("UPDATE Achievement SET finished = 1 WHERE id LIKE '" + parentId + "'");
					stmt.close();

					stmt = c.createStatement();
					String sql = "INSERT OR IGNORE INTO Achieved VALUES ";

					for(Map.Entry<Integer, Integer> i : checks.entrySet())
						sql += "(" + i.getKey() + ", '" + parentId + "'), ";

					if(sql.length() > 38)
						stmt.executeUpdate(sql.substring(0, sql.length() - 2));
					stmt.close();
				}else{
					finished.put(parentId, false);

					stmt.executeUpdate("UPDATE Achievement SET finished = 0 WHERE id LIKE '" + parentId + "'");
					stmt.close();

					for(Map.Entry<Integer, Integer> i : checks.entrySet()){
						stmt = c.createStatement();

						if(i.getValue() == 1){
							Statement stmt2 = c.createStatement();
							set = stmt2.executeQuery("SELECT COUNT(*) FROM Achieved, Achievement "
									+ "WHERE Achievement.id = Achieved.achievement "
									+ "AND achievement.parent LIKE '" + parentId + "' "
									+ "AND player = " + i.getKey());
							set.next();
							int count2 = set.getInt(1);
							stmt2.close();

							stmt2 = c.createStatement();
							set = stmt2.executeQuery("SELECT COUNT(*) FROM Achievement WHERE parent LIKE '" + parentId + "'");
							set.next();
							int count3 = set.getInt(1);
							stmt2.close();

							if(count2 == count3){
								stmt2 = c.createStatement();
								stmt2.executeUpdate("INSERT OR IGNORE INTO Achieved VALUES (" + i.getKey() + ", '" + parentId + "')");
								stmt2.close();
							}
						}else{
							stmt.executeUpdate("DELETE FROM Achieved WHERE player = " + i.getKey() + " AND achievement LIKE '" + parentId + "'");
						}

						stmt.close();
					}
				}

				stmt = c.createStatement();
				set = stmt.executeQuery("SELECT parent FROM Achievement WHERE id LIKE '" + parentId + "'");
				set.next();
				String grandParentId = set.getString(1);
				stmt.close();

				finishParent(grandParentId, checks, finished);

			} catch(Exception e) {
				e.printStackTrace();
			}
		}else{
			finished.put(parentId, false);
		}
	}


	private void finishChildren(boolean finish, String currentId, Map<Integer, Integer> checks, Map<String, Boolean> finished) {
		if(!currentId.contains("SBQ-")){
			try {
				Connection c = database.getConnection();
				Statement stmt = c.createStatement();

				if(finish){ // OK
					ResultSet set = stmt.executeQuery("SELECT id FROM Achievement WHERE parent LIKE '" + currentId + "'");

					while(set.next()){
						String childId = set.getString(1);
						
						finished.put(childId, true);

						Statement stmt2 = c.createStatement();
						stmt2.executeUpdate("UPDATE Achievement SET finished = 1 WHERE id LIKE '" + childId + "'");
						stmt2.close();

						stmt2 = c.createStatement();
						String sql = "INSERT OR IGNORE INTO Achieved VALUES ";

						for(Map.Entry<Integer, Integer> i : checks.entrySet())
							sql += "(" + i.getKey() + ", '" + childId + "'), ";

						if(sql.length() > 38)
							stmt2.executeUpdate(sql.substring(0, sql.length() - 2));
						stmt2.close();

						finishChildren(true, childId, checks, finished);
					}

					stmt.close();
				}else{
					ResultSet set = stmt.executeQuery("SELECT id FROM Achievement WHERE parent LIKE '" + currentId + "'");

					while(set.next()){
						String childId = set.getString(1);

						finished.put(childId, false);

						Statement stmt2 = c.createStatement();
						stmt2.executeUpdate("UPDATE Achievement SET finished = 0 WHERE id LIKE '" + childId + "'");
						stmt2.close();

						stmt2 = c.createStatement();
						String sql = "INSERT OR IGNORE INTO Achieved VALUES ";
						
						for(Map.Entry<Integer, Integer> i : checks.entrySet()){
							if(i.getValue() == 1)
								sql += "(" + i.getKey() + ", '" + childId + "'), ";
						}

						if(sql.length() > 38)
							stmt2.executeUpdate(sql.substring(0, sql.length() - 2));
						stmt2.close();

						stmt2 = c.createStatement();
						sql = "DELETE FROM Achieved WHERE ";

						for(Map.Entry<Integer, Integer> i : checks.entrySet()){
							if(i.getValue() == 0)
								sql += "(player = " + i.getKey() + " AND achievement LIKE '" + childId + "') OR ";
						}

						if(sql.length() > 27)
							stmt2.executeUpdate(sql.substring(0, sql.length() - 4));
						stmt2.close();
						
						stmt2 = c.createStatement();
						ResultSet set2 = stmt2.executeQuery("SELECT COUNT(*) FROM Achieved WHERE achievement LIKE '" + childId + "'");
						set2.next();
						int nbAchieved = set2.getInt(1);
						if(nbAchieved == checks.size())
							finished.put(childId, true);
						stmt2.close();

						finishChildren(false, childId, checks, finished);
					}

					stmt.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Getter for the instance
	 * @return
	 */
	public static DatabaseInsertion getInstance() {
		return instance;
	}
}
