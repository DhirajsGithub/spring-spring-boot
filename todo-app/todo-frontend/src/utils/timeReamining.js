export const calculateTimeRemaining = (targetDate) => {
    const today = new Date();
    const target = new Date(targetDate);
    
    // If target date is invalid
    if (isNaN(target.getTime())) return null;
  
    // Calculate difference in milliseconds
    const difference = target.getTime() - today.getTime();
    
    // Convert to days
    const daysRemaining = Math.ceil(difference / (1000 * 3600 * 24));
    
    return {
      days: Math.abs(daysRemaining),
      isOverdue: daysRemaining < 0,
      isPastDue: daysRemaining <= 0,
      isSoon: daysRemaining > 0 && daysRemaining <= 3,
      isFarAway: daysRemaining > 3
    };
  };
  
  export const getTimeRemainingText = (targetDate) => {
    const timeInfo = calculateTimeRemaining(targetDate);
    
    if (!timeInfo) return 'Invalid Date';
    
    if (timeInfo.isPastDue) {
      return `Overdue by ${timeInfo.days} day${timeInfo.days !== 1 ? 's' : ''}`;
    }
    
    return `${timeInfo.days} day${timeInfo.days !== 1 ? 's' : ''} remaining`;
  };