package gr.aueb.animalshelter.DAO;

    /**
     * Factory for construction of Dao objects
     * The class that implements the abstract factory is defines by the
     * system property {@code daofactory}.
     * @author _Katerina_
     */
    public abstract class DAOFactory {

        private static DAOFactory factory = null;

        /**
         * Returns DAO object production factory
         * @return Factory for Dao objects
         */
        public static DAOFactory getFactory() {
            if (factory == null) {
                String className = null;

                if (System.getProperty("daofactory") != null) {
                    className = System.getProperty("daofactory");
                }

                try {
                    factory = (DAOFactory) Class.forName(className).newInstance();
                } catch (Exception e) {
                    System.out.println("Dao Factory Exception");
                }
            }
            return factory;
        }


        /**
         * Returns object for interface {@link AdopterDao}.
         * @return Object AdopterDAO.
         */
        public abstract AdopterDao getAdopterDAO();


        /**
         * Returns object for interface {@link AdoptionDao}.
         * @return Object AdoptionDAO.
         */
        public abstract AdoptionDao getAdoptionDAO();

        /**
         * Returns object for interface {@link AdoptionRequestDao}.
         * @return Object AdoptionRequestDAO.
         */
        public abstract AdoptionRequestDao getAdoptionRequestDAO();

        /**
         * Returns object for interface {@link AnimalDao}.
         * @return Object AnimalDAO.
         */
        public abstract AnimalDao getAnimalDAO();

        /**
         * Returns object for interface {@link FeedingScheduleDao}.
         * @return Object FeedingScheduleDAO.
         */
        public abstract FeedingScheduleDao getFeedingScheduleDAO();

        //insert rest of dao getters
/*
        /**
         * Returns object for interface {@link Obligation_fDao}.
         * @return Object Obligation_fDAO.
         */
 /*
        public abstract Obligation_fDao getObligation_fDAO();

        /**
         * Returns object for interface {@link Obligation_oDao}.
         * @return Object Obligation_oDAO.
         */
        /*
        public abstract Obligation_oDao getObligation_oDAO();
        /**
         * Returns object for interface {@link EmployeeDao}.
         * @return Object EmployeeDAO.
         */
        /*
        public abstract EmployeeDao getEmployeeDAO();*/
    }

