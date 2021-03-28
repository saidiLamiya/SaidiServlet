# Base de données: `magasin`
# Structure de la table `commande`
#
CREATE TABLE commande (
 num tinyint(4) NOT NULL auto_increment,
 article varchar(20) NOT NULL default '',
 qui tinyint(4) NOT NULL default '0',
 PRIMARY KEY (num)
) TYPE=MyISAM;
# --------------------------------------------------------
#
# Structure de la table `personnel`
#
CREATE TABLE personnel (
 numero tinyint(4) NOT NULL auto_increment,
 nom varchar(20) NOT NULL default '',
 PRIMARY KEY (numero)
) TYPE=M